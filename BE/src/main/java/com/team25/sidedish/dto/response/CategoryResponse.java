package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryResponse {

    private Long id;
    private String name;
    private int count;

    public static CategoryResponse from(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.id = category.getId();
        categoryResponse.name = category.getName();
        categoryResponse.count = category.getProductCount();
        return categoryResponse;
    }
}
