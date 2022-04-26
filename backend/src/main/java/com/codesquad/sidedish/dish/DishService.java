package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.domain.RecommendRef;
import com.codesquad.sidedish.dish.dto.DishListResponse;
import com.codesquad.sidedish.dish.dto.DishUnitResponse;
import com.codesquad.sidedish.dish.dto.Slice;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public Slice<DishListResponse> findDishesBySection(String sectionName) {
        List<Dish> dishes = dishRepository.findBySectionName(sectionName);

        List<DishListResponse> responses = dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

    public Slice<DishListResponse> findDishesByCategory(String categoryName) {
        List<Dish> dishes = dishRepository.findByCategoryName(categoryName);

        List<DishListResponse> responses = dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
        return new Slice<>(responses);
    }

    public DishUnitResponse findDish(Integer dishId) {
        Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new IllegalArgumentException("반찬을 찾을 수 없습니다."));

        return DishUnitResponse.from(dish);
    }

    public List<DishListResponse> findRecommendDishes(Integer dishId) {
        Dish dish = dishRepository.findById(dishId)
            .orElseThrow(() -> new IllegalArgumentException("반찬을 찾을 수 없습니다."));

        List<Integer> dishIds = dish.getRecommends().stream()
            .map(RecommendRef::getRecommendeeId)
            .collect(Collectors.toList());
        List<Dish> dishes = dishRepository.findByIdIn(dishIds);

        return dishes.stream()
            .map(DishListResponse::from)
            .collect(Collectors.toList());
    }

}
