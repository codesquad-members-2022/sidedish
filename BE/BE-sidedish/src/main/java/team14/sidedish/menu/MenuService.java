package team14.sidedish.menu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import team14.sidedish.event.EventAndSalesDto;
import team14.sidedish.event.EventService;
import team14.sidedish.eventplanner.EventPlannerDto;
import team14.sidedish.eventplanner.EventPlannerService;
import team14.sidedish.exhibition.ExhibitionDto;
import team14.sidedish.exhibition.ExhibitionService;
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

	/**
	 * 1. 현재 진행중인 기획전에 대한 추천메뉴(specialNumber) 목록을 가져옵니다.
	 * 2. 첫번째 카테고리에 해당하는 메뉴 목록 조회합니다.
	 * 3. 각각의 추천메뉴와 카테고리의 메뉴 내에서 이벤트가 진행중인 메뉴목륵을 조회합니다.
	 * 4. 3의 결과에 진행중인 이벤트에 대한 이벤트 목록과 할인정보 추가합니다.
	 */
	@Transactional(readOnly = true)
	public MenuDto.Response readExhibition(int specialNumber) {
		SpecialMenuModel specialMenuTitle = SpecialMenuModel.from(specialNumber);
		ExhibitionDto exhibitionInfo = exhibitionService.readOngoing();
		List<MenuDto.SubCategory> specialMenus = specialMenuService.read(exhibitionInfo.getExhibitionId(), specialMenuTitle.getTitle());
		List<Menu> menuInfo = menuRepository.findByCategory(Menu.Category.SIDE_DISH);  // todo 10개 - LessThanEqual() or Pageable
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
			Menu.Category.MAIN_DISH.getId(),
			Menu.Category.MAIN_DISH.getKoType(),
			menus);
		return new MenuDto.Response(exhibitionResponse, categoryResponse);
	}

	public MenuDto.DetailResponse readFrom(Long menuId) {
		Menu menuInfo = menuRepository.findById(menuId)
			.orElseThrow(() -> new IllegalArgumentException("error of menuId - read"));
		Menu.Category subjectOfCategory = menuInfo.getCategory();

		List<Menu> category = menuRepository.findByCategory(subjectOfCategory);  // todo 10개 - LessThanEqual() or Pageable
		List<MenuDto.SubCategory> menus = getSubCategoryOf(category);
		Set<Long> menuIds = getMenuIds(menus);
		EventPlannerDto.Ids ids = eventPlannerService.readOngoingEventOf(List.copyOf(menuIds));
		List<Long> eventIds = ids.getEventIds();
		EventAndSalesDto eventAndSales = eventService.read(eventIds);
		insertSalesAndEventBadge(menus, ids, eventAndSales);

		MenuDto.SubCategory detailMenu = getDetailMenu(menuInfo, menus);
		menus.remove(detailMenu);
		MenuDto.DetailResponse response = new MenuDto.DetailResponse(
			detailMenu,
			menuInfo.availableForSale(),
			new MenuDto.CategoryResponse(subjectOfCategory.getId(), subjectOfCategory.getKoType(), menus));

		Function<Boolean, Integer> savedCharge = (isDiscounted) -> isDiscounted ?
			response.getMenu().getDiscountedPrice() :
			response.getMenu().getPrice().intValue();

		Integer charge = savedCharge.apply(eventAndSales.hasDiscounted());
		response.setSavedCharge(charge);
		return response;
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
				return MenuDto.SubCategory.builder()
					.menuId(menu.getMenuId())
					.menuName(menu.getName())
					.description(menu.getDescription())
					.image(menu.getImages())
					.originalPrice(menu.getPrice())
					.build();
			}).collect(Collectors.toList());
		return categories;
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
}


/**
 * 타입 이용한 insertSalesAndEventBadge() 내 공통 메서드 분리 실패
 */
/*	private void menuDiscountAndEvent(EventPlannerDto.Ids ids, EventAndSalesDto eventAndSales,
		MenuModel menuModel) {
		Optional<EventPlannerDto.Id> eventMenu = ids.findOngoingEvent(menuModel);
		if (eventMenu.isPresent()) {
			EventPlannerDto.Id id = eventMenu.get();
			BigDecimal discountedPrice = getDiscountedPrice(eventAndSales, menuModel, id);
			List<String> eventBadges = eventAndSales.getEventBadges(id);
			menuModel.setDiscountedPrice(discountedPrice);
			menuModel.setEvent(eventBadges);
		}
		menuModel.setDiscountedPrice(BigDecimal.ZERO);
		menuModel.setEvent(List.of());
	}*/
