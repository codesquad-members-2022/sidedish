package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team31.codesuqad.sidedish.controller.dto.DetailedDishDto;
import team31.codesuqad.sidedish.controller.dto.RecommendDto;
import team31.codesuqad.sidedish.domain.Delivery;
import team31.codesuqad.sidedish.domain.DiscountPolicy;
import team31.codesuqad.sidedish.domain.Dish;
import team31.codesuqad.sidedish.repository.DishRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class DishService {

    private final DishRepository dishRepository;
    private final DeliveryService deliveryService;
    private final DiscountPolicyService discountPolicyService;

    private static final int NUMBER_PER_PAGE = 5;

    public DishService(DishRepository dishRepository, DeliveryService deliveryService, DiscountPolicyService discountPolicyService) {
        this.dishRepository = dishRepository;
        this.deliveryService = deliveryService;
        this.discountPolicyService = discountPolicyService;
    }

    public List<Dish> findAll() {
        List<Dish> dishes = dishRepository.findAll();
        discountPolicyService.mappingDiscountPolicies(dishes);
        return dishes;
    }

    public List<Dish> findThreeByEventTabId(Integer eventId) {
        List<Dish> dishes = dishRepository.findThreeByEventTabId(eventId);
        discountPolicyService.mappingDiscountPolicies(dishes);
        return dishes;
    }

    public List<Dish> findAllByCategoryId(Integer categoryId) {
        List<Dish> dishes = dishRepository.findAllByCategoryId(categoryId);
        discountPolicyService.mappingDiscountPolicies(dishes);
        return dishes;
    }

    public DetailedDishDto findByDishId(long dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new NoSuchElementException("음식 정보가 없습니다."));

        Map<Integer, DiscountPolicy> discountPolicyMap = discountPolicyService.getDiscountPolicyMap();
        dish.mappingDiscountPolicies(discountPolicyMap);

        Delivery delivery = deliveryService.findById(dish.getDeliveryId())
                .orElseThrow(() -> new NoSuchElementException("딜러버리 정보가 없습니다."));

        return new DetailedDishDto(dish, delivery);
    }

    public RecommendDto findRecommendDishes(int page) {
        // offset은 0부터 시작해서 페이지 - 1을 해준다.
        int offsetNumber = NUMBER_PER_PAGE * (page - 1);
        List<Dish> dishes = dishRepository.findRecommendedPage(offsetNumber);

        // 추천 메뉴의 개수가 NUMBER_PER_PAGE에 나누어 떨어지지 않으면 1개의 페이지가 더 필요하다.
        int pageCount = (dishRepository.findRecommendSize() % NUMBER_PER_PAGE) == 0
                ? (dishRepository.findRecommendSize() / NUMBER_PER_PAGE)
                : (dishRepository.findRecommendSize() / NUMBER_PER_PAGE) + 1;

        return new RecommendDto(dishes, pageCount);
    }

}
