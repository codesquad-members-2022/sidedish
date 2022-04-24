package com.codesquad.sidedish.category;

import com.codesquad.sidedish.dish.dto.DishResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryResponse {

    private final Integer categoryId;
    private final String categoryName;

    // relation
    private final List<DishResponse> dishes;

    public static CategoryResponse from(Category category) {
        List<DishResponse> dishes = category.getDishes() != null
            ? category.getDishes().stream()
            .map(DishResponse::from)
            .collect(Collectors.toList()) : null;

        return new CategoryResponse(
            category.getId(),
            category.getCategoryName(),
            dishes
        );
    }
}
