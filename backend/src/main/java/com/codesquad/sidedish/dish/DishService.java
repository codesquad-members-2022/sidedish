package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.RecommendRef;
import com.codesquad.sidedish.dish.dto.DishListResponse;
import com.codesquad.sidedish.dish.dto.DishUnitResponse;
import com.codesquad.sidedish.exception.ErrorCode;
import com.codesquad.sidedish.exception.unchecked.NotFoundException;
import com.codesquad.sidedish.other.page.Criteria;
import com.codesquad.sidedish.other.page.Slice;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public Slice<DishListResponse> findDishesBySection(String sectionName, Criteria criteria) {
        List<Dish> dishes = dishRepository.findBySectionName(
            sectionName, criteria.getLimit(), criteria.getOffset());

        List<DishListResponse> responses = dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses, criteria);
    }

    public Slice<DishListResponse> findDishesByCategory(String categoryName, Criteria criteria) {
        List<Dish> dishes = dishRepository.findByCategoryName(
            categoryName, criteria.getLimit(), criteria.getOffset());

        List<DishListResponse> responses = dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses, criteria);
    }

    public DishUnitResponse findDish(Integer dishId) {
        Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new NotFoundException(ErrorCode.DISH_NOT_FOUND));

        return DishUnitResponse.from(dish);
    }

    public Slice<DishListResponse> findRecommendDishes(Integer dishId, Criteria criteria) {
        Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new NotFoundException(ErrorCode.DISH_NOT_FOUND));

        List<Integer> dishIds = dish.getRecommends().stream()
            .map(RecommendRef::getRecommendeeId)
            .collect(Collectors.toList());
        List<Dish> dishes = dishRepository.findByIdIn(
            dishIds, criteria.getLimit(), criteria.getOffset());

        List<DishListResponse> dishResponses = dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(dishResponses, criteria);
    }

}
