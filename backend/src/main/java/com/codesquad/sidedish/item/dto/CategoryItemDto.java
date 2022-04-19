package com.codesquad.sidedish.item.dto;

import java.util.List;

public class CategoryItemDto {
    private String categoryName;
    private List<ItemDto> items;

    public CategoryItemDto(String categoryName, List<ItemDto> items) {
        this.categoryName = categoryName;
        this.items = items;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
