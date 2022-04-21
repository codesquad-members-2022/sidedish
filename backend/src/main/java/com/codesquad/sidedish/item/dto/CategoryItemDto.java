package com.codesquad.sidedish.item.dto;

import java.util.List;

public class CategoryItemDto {
    private String categoryName;
    private List<ItemDto> itemsInCategory;

    public CategoryItemDto(String categoryName, List<ItemDto> itemsInCategory) {
        this.categoryName = categoryName;
        this.itemsInCategory = itemsInCategory;
    }

    public void addItemDto(ItemDto itemDto) {
        itemsInCategory.add(itemDto);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<ItemDto> getItemsInCategory() {
        return itemsInCategory;
    }
}
