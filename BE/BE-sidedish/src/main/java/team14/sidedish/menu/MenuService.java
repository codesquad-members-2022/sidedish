package team14.sidedish.menu;

import static team14.sidedish.common.Exception.InvalidOrderException.ERROR_OF_ORDER_DEVLIVERY_CHARGE;
import static team14.sidedish.common.Exception.InvalidOrderException.ERROR_OF_ORDER_IN_SOLD_OUT;
import static team14.sidedish.common.Exception.InvalidOrderException.ERROR_OF_ORDER_SAVED_CHARGE;
import static team14.sidedish.common.Exception.InvalidOrderException.ERROR_OF_ORDER_TOTAL_PRICE;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import team14.sidedish.common.Exception.InvalidOrderException;
import team14.sidedish.event.EventAndSalesDto;
import team14.sidedish.event.EventService;
import team14.sidedish.eventplanner.EventPlannerDto;
import team14.sidedish.eventplanner.EventPlannerService;
import team14.sidedish.exhibition.ExhibitionDto;
import team14.sidedish.exhibition.ExhibitionService;
import team14.sidedish.order.Order;
import team14.sidedish.order.OrderDto;
import team14.sidedish.order.OrderInfo;
import team14.sidedish.order.OrderRepository;
import team14.sidedish.specialmenu.SpecialMenuService;
import team14.sidedish.specialmenu.enums.SpecialMenuModel;

@RequiredArgsConstructor
@Service
public class MenuService {
	private final ExhibitionService exhibitionService;
	private final SpecialMenuService specialMenuService;
	private final EventPlannerService eventPlannerService;
	private final EventService eventService;

	private final MenuRepository menuRepository;
	private final OrderRepository orderRepository;

	private BiFunction<Boolean, MenuDto.SubCategory, Integer> savedCharge = (isDiscounted, subCategory) -> isDiscounted ?
		subCategory.getDiscountedPrice() :
		subCategory.getPrice().intValue();

	/**
	 * 1. 현재 진행중인 기획전에 대한 추천메뉴(specialNumber) 목록을 가져옵니다.
	 * 2. 첫번째 카테고리에 해당하는 메뉴 목록 조회합니다.
	 * 3. 각각의 추천메뉴와 카테고리의 메뉴 내에서 이벤트가 진행중인 메뉴목륵을 조회합니다.
	 * 4. 3의 결과에 진행중인 이벤트에 대한 이벤트 목록과 할인정보 추가합니다.
	 */
	@Transactional(readOnly = true)
	public MenuDto.Response readExhibition(int specialNumber, PageRequest pageable) {
		SpecialMenuModel specialMenuTitle = SpecialMenuModel.from(specialNumber);
		ExhibitionDto exhibitionInfo = exhibitionService.readOngoing();
		List<MenuDto.SubCategory> specialMenus = specialMenuService.read(exhibitionInfo.getExhibitionId(), specialMenuTitle.getTitle());
		List<Menu> menuInfo = menuRepository.findByCategory(Menu.Category.SIDE_DISH, pageable);  // todo 10개 - LessThanEqual() or Pageable
		List<MenuDto.SubCategory> menus = getSubCategoryOf(menuInfo);

		// 추천메뉴, 카테고리별 메뉴 내 menuId들을 중복없이 모아 진행중인 이벤트를 조회합니다.
		Set<Long> specialMenuIds = getMenuIds(specialMenus);
		Set<Long> menuIds = getMenuIds(menus);
		menuIds.addAll(specialMenuIds);
		EventPlannerDto.Ids ids = eventPlannerService.readOngoingEventOf(List.copyOf(menuIds));
		List<Long> eventIds = ids.getEventIds();

		// menuId 별 이벤트제목, 할인가격 추가조회 (요청받은 추천메뉴 + 전송할 카테고리내 메뉴 : 많아야 13개)
		EventAndSalesDto eventAndSales = eventService.read(eventIds);
		insertSalesAndEventBadge(specialMenus, ids, eventAndSales);
		insertSalesAndEventBadge(menus, ids, eventAndSales);

		MenuDto.ExhibitionResponse exhibitionResponse = new MenuDto.ExhibitionResponse(
			exhibitionInfo.getTitle(),
			new MenuDto.CategoryResponse(specialMenuTitle.getId(), specialMenuTitle.getTitle(), specialMenus));

		MenuDto.CategoryResponse categoryResponse = new MenuDto.CategoryResponse(
			Menu.Category.SIDE_DISH.getId(),
			Menu.Category.SIDE_DISH.getKoType(),
			menus);
		return new MenuDto.Response(exhibitionResponse, categoryResponse);
	}

	public List<MenuDto.CategoryResponse> readMoreCategories() {
		List<MenuDto.CategoryResponse> categories = new ArrayList<>();

		getMenu(categories, Menu.Category.MAIN_DISH);
		getMenu(categories, Menu.Category.SOUP);

		return categories;
	}

	public MenuDto.CategoryResponse readSpecialMenu(int specialMenuId) {
		SpecialMenuModel specialMenuTitle = SpecialMenuModel.from(specialMenuId);
		ExhibitionDto exhibitionInfo = exhibitionService.readOngoing();

		List<MenuDto.SubCategory> specialMenus = specialMenuService.read(exhibitionInfo.getExhibitionId(), specialMenuTitle.getTitle());

		Set<Long> specialMenuIds = getMenuIds(specialMenus);
		EventPlannerDto.Ids ids = eventPlannerService.readOngoingEventOf(List.copyOf(specialMenuIds));
		List<Long> eventIds = ids.getEventIds();
		EventAndSalesDto eventAndSales = eventService.read(eventIds);
		insertSalesAndEventBadge(specialMenus, ids, eventAndSales);

		return new MenuDto.CategoryResponse(specialMenuTitle.getId(), specialMenuTitle.getTitle(), specialMenus);
	}

	public MenuDto.DetailResponse readFrom(Long menuId) {
		PageRequest pageable = PageRequest.of(0, 10);
		Menu menuInfo = getMenu(menuId);
		Menu.Category subjectOfCategory = menuInfo.getCategory();
		// 함께하면 더욱 맛있는 상품은 조회요청한 메뉴의 Category와 동일
		List<Menu> category = menuRepository.findByCategory(subjectOfCategory, pageable);
		List<MenuDto.SubCategory> menus = getSubCategoryOf(category);
		filledEvent(menus);

		MenuDto.SubCategory detailMenu = getDetailMenu(menuInfo, menus);
		menus.remove(detailMenu);
		MenuDto.DetailResponse response = new MenuDto.DetailResponse(
			detailMenu,
			menuInfo.availableForSale(),
			new MenuDto.CategoryResponse(subjectOfCategory.getId(), subjectOfCategory.getKoType(), menus));

		Integer charge = savedCharge.apply(detailMenu.hasDiscounted(), detailMenu);
		response.setSavedCharge(charge);
		return response;
	}

	private void filledEvent(List<MenuDto.SubCategory> subCategories) {
		Set<Long> menuIds = getMenuIds(subCategories);
		EventPlannerDto.Ids ids = eventPlannerService.readOngoingEventOf(List.copyOf(menuIds));
		List<Long> eventIds = ids.getEventIds();
		EventAndSalesDto eventAndSales = eventService.read(eventIds);
		insertSalesAndEventBadge(subCategories, ids, eventAndSales);
	}

	/**
	 * - menuId를 통해 조회합니다.
	 *   - 주문 수량에 대해 주문 가능 여부 확인합니다.
	 *   - 주문시 결제 금액과 실제 계산 금액이 동일 한지 검증합니다.
	 *   	- 결제금액의 1% 가 적립금이 됩니다.
	 *      - 배송비 2500원 지불됩니다.
	 *        - 총 주문금액이 40000원 이상이면 배송비 제외 됩니다.
	 * - 주문 진행
	 * - 주문 성공시, 총 주문수량, 총 결제 금액, 총 결제금액에 포함된 배송비, 적립금 등을 반환합니다.
	 * @param request
	 */
	@Transactional
	public OrderDto.Response createOrder(OrderDto.Request request) {
		Menu menuInfo = getMenu(request.getMenuId());
		if (!menuInfo.availableForOrder(request.getCountOfOrder())) {
			throw new InvalidOrderException(ERROR_OF_ORDER_IN_SOLD_OUT);
		}

		MenuDto.SubCategory subCategory = getSubCategoryWithEvent(menuInfo);
		// 주문금액 : (한개의 주문금액 = 할인가격 or 원래가격) * 주문수량
		int totalPrice = getTotalPrice(request, subCategory);
		int deliveryCharge = OrderInfo.DELIVERY_CHARGE.calculate(totalPrice);
		int savedCharge = OrderInfo.SAVED_CHARGE.calculate(totalPrice);

		isValidOrderValue(request, totalPrice, deliveryCharge, savedCharge);

		int totalDiscountedPrice = menuInfo.getPrice().subtract(BigDecimal.valueOf(subCategory.getDiscountedPrice())).intValue();
		if (deliveryCharge == 0) {
			totalDiscountedPrice -= OrderInfo.BASE_DELIVERY_CHARGE.calculate(0);
		}

		Order order = Order.of(totalDiscountedPrice, savedCharge, OrderInfo.DELIVERY_INFO.getTitle(), deliveryCharge, 1L, menuInfo.getMenuId());
		orderRepository.save(order);
		return new OrderDto.Response(totalPrice, totalDiscountedPrice,savedCharge, deliveryCharge);
	}

	// TODO 타니 메서드에 PAGE 만 추가 OK
	public  MenuDto.CategoryResponse readListFrom(int categoryId, PageRequest pageable) {
		Menu.Category menuCategory = Menu.Category.from(categoryId);

		List<Menu> category = menuRepository.findByCategory(menuCategory, pageable);
		List<MenuDto.SubCategory> menus = getSubCategoryOf(category);
		filledEvent(menus);

		return new MenuDto.CategoryResponse(menuCategory.getId(), menuCategory.getKoType(), menus);
	}

	private Menu getMenu(Long menuId) {
		return menuRepository.findById(menuId)
			.orElseThrow(() -> new IllegalArgumentException("error of menuId - read"));
	}

	private MenuDto.SubCategory getDetailMenu(Menu menuInfo, List<MenuDto.SubCategory> menus) {
		return menus.stream()
			.filter(m -> m.getMenuId().equals(menuInfo.getMenuId()))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("error of selected menu id"));
	}

	private List<MenuDto.SubCategory> getSubCategoryOf(List<Menu> menus) {
		List<MenuDto.SubCategory> categories = menus.stream()
			.map(menu -> {
				return subCategoryFrom(menu);
			}).collect(Collectors.toList());
		return categories;
	}

	private MenuDto.SubCategory subCategoryFrom(Menu menu) {
		return MenuDto.SubCategory.builder()
			.menuId(menu.getMenuId())
			.menuName(menu.getName())
			.description(menu.getDescription())
			.image(menu.getImages())
			.originalPrice(menu.getPrice())
			.build();
	}

	/**
	 * MenuDto.SubCategory의 메뉴 정보에 할인가격, 이벤트 배지 정보 추가 합니다.
	 * @param subCategories
	 * @param ids
	 * @param eventAndSales
	 */
	private void insertSalesAndEventBadge(List<MenuDto.SubCategory> subCategories, EventPlannerDto.Ids ids,
		EventAndSalesDto eventAndSales) {
		subCategories.stream()
			.map(category -> {
				Optional<EventPlannerDto.Id> eventMenu = ids.findOngoingEvent(category);
				if (eventMenu.isPresent()) {
					EventPlannerDto.Id id = eventMenu.get();
					BigDecimal discountedPrice = getDiscountedPrice(eventAndSales, category, id);
					List<String> eventBadges = eventAndSales.getEventBadges(id);
					category.setDiscountedPrice(discountedPrice);
					category.setEvent(eventBadges);
					return category;
				}
				category.setDiscountedPrice(BigDecimal.ZERO);
				category.setEvent(List.of());
				return category;
			})
			.collect(Collectors.toList());
	}

	private BigDecimal getDiscountedPrice(EventAndSalesDto eventAndSales, MenuModel category, EventPlannerDto.Id id) {
		List<BigDecimal> deductibleAmounts = eventAndSales.getDeductibleAmounts(category, id);
		BigDecimal discountedPrice = category.getPrice();

		for (BigDecimal deductibleAmount : deductibleAmounts) {
			discountedPrice = discountedPrice.subtract(deductibleAmount);
		}

		return discountedPrice;
	}

	private Set<Long> getMenuIds(List<MenuDto.SubCategory> menus) {
		return menus.stream()
			.parallel()
			.map(menu -> menu.getMenuId())
			.collect(Collectors.toSet());
	}

	private void getMenu(List<MenuDto.CategoryResponse> categories, Menu.Category menuCategory) {
		PageRequest pageable = PageRequest.of(0, 10);
		List<Menu> mainMenuInfo = menuRepository.findByCategory(menuCategory, pageable);
		List<MenuDto.SubCategory> mainMenus = getSubCategoryOf(mainMenuInfo);

		Set<Long> mainMenuIds = getMenuIds(mainMenus);
		EventPlannerDto.Ids mainIds = eventPlannerService.readOngoingEventOf(List.copyOf(mainMenuIds));
		List<Long> mainMenuEventIds = mainIds.getEventIds();
		EventAndSalesDto mainMenuEventAndSales = eventService.read(mainMenuEventIds);
		insertSalesAndEventBadge(mainMenus, mainIds, mainMenuEventAndSales);

		categories.add(new MenuDto.CategoryResponse(
				menuCategory.getId(),
				menuCategory.getKoType(),
				mainMenus
		));
	}

	private void isValidOrderValue(OrderDto.Request request, int totalPrice, int deliveryCharge, int savedCharge) {
		String className = this.getClass().getSimpleName();
		if (!request.isEqualsTotalOrderPrice(totalPrice)) {
			throw new InvalidOrderException(totalPrice, ERROR_OF_ORDER_TOTAL_PRICE, request.getTotalOrderAmount());
		}
		if (!request.isEqualsDeliverCharge(deliveryCharge)) {
			throw new InvalidOrderException(deliveryCharge, ERROR_OF_ORDER_DEVLIVERY_CHARGE, request.getDeliveryCharge());
		}
		if (!request.isEqualsSavedCharge(savedCharge)) {
			throw new InvalidOrderException(savedCharge, ERROR_OF_ORDER_SAVED_CHARGE, request.getSavedCharge());
		}
	}

	private int getTotalPrice(OrderDto.Request request, MenuDto.SubCategory subCategory) {
		if (subCategory.getDiscountedPrice() > 0) {
			return subCategory.getDiscountedPrice() * request.getCountOfOrder();
		}
		return subCategory.getPrice().multiply(BigDecimal.valueOf(request.getCountOfOrder())).intValue();
	}

	private MenuDto.SubCategory getSubCategoryWithEvent(Menu menuInfo) {
		List<MenuDto.SubCategory> subCategories = getSubCategoryOf(List.of(menuInfo));
		List<MenuDto.SubCategory> menusWithEventAndDiscounted = insertEventAndSale(subCategories);
		MenuDto.SubCategory subCategory = menusWithEventAndDiscounted.get(0);
		return subCategory;
	}

	private List<MenuDto.SubCategory> insertEventAndSale(List<MenuDto.SubCategory> subCategories) {
		EventPlannerDto.Ids ids = eventPlannerService.readOngoingEventOf(List.of(subCategories.get(0).getMenuId()));
		List<Long> eventIds = ids.getEventIds();
		EventAndSalesDto eventAndSales = eventService.read(eventIds);
		insertSalesAndEventBadge(subCategories, ids, eventAndSales);
		return subCategories;
	}
}
