package com.team34.sidedish.dto;

import java.util.List;

public class CategoriesResponse {

    private List<CategoryResponse> categories;

    public CategoriesResponse(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "CategoriesResponse{" +
            "categories=" + categories +
            '}';
    }
}
