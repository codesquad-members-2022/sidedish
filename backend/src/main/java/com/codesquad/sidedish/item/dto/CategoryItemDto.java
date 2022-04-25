package com.codesquad.sidedish.item.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class CategoryItemDto {
    @Schema(description = "반찬 카테고리 이름", example = "모두가 좋아하는 든든한 메인요리")
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
