package com.sidedish.api.categories.dto;

import com.sidedish.domain.CategoryType;

import java.util.List;

import lombok.Getter;

@Getter
public class ResponseItemList {

    private final String detailTitle;
    private final int maxPage;
    private final List<ItemResource> itemResource;

    public ResponseItemList(CategoryType type, List<ItemResource> itemResource, int totalPage) {
        this.detailTitle = type.getTitle();
        this.maxPage = totalPage;
        this.itemResource = itemResource;
    }
}
