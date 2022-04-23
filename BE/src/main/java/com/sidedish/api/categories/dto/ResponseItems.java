package com.sidedish.api.categories.dto;

import com.sidedish.domain.CategoryType;

import java.util.List;

import lombok.Getter;

@Getter
public class ResponseItems {

    private final CategoryType categoryType;
    private final List<ResponseItemDto> items;

    public ResponseItems(CategoryType categoryType, List<ResponseItemDto> items) {
        this.categoryType = categoryType;
        this.items = items;
    }
}
