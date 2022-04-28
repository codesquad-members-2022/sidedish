package com.codesquad.sidedish.category.dto;

import com.codesquad.sidedish.category.domain.Category;
import com.codesquad.sidedish.category.domain.DishRef;
import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.dish.dto.DishListResponse;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryResponse {

    private final Integer categoryId;
    private final String categoryName;

    private final List<DishListResponse> dishes;

    public static CategoryResponse of(Category category, List<Dish> dishes) {
        Map<Integer, Dish> dishMap = dishes.stream()
            .collect(Collectors.toMap(Dish::getId, Function.identity()));

        return new CategoryResponse(
            category.getId(),
            category.getCategoryName(),
            category.getDishes()
                .stream()
                .map(DishRef::getDishId)
                .map(dishMap::get)
                .map(DishListResponse::from)
                .collect(Collectors.toList()));
    }

}
