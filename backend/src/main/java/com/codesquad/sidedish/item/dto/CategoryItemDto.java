package com.codesquad.sidedish.item.dto;

import java.util.List;

public class CategoryItemDto {
    private String categoryName;
    private List<ItemDto> items;

    public CategoryItemDto(String categoryName, List<ItemDto> itemsInCategory) {
        this.categoryName = categoryName;
        this.items = itemsInCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
