package com.codesquad.sidedish.item.dto;

import java.util.List;

public class CategoryItemsDto {
    private List<CategoryItemDto> items;

    public CategoryItemsDto(List<CategoryItemDto> items) {
        this.items = items;
    }

    public List<CategoryItemDto> getItems() {
        return items;
    }
}
