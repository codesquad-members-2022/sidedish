package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import com.sidedish.domain.product.MainCategory;
import lombok.Getter;

@Getter
public class MainCategoryProductDto {
    private String productName;
    private String description;
    private int price;
    private EventBadge eventBadge;
    private MainCategory mainCategory;

    public MainCategoryProductDto(String productName, String description, int price, EventBadge eventBadge, MainCategory mainCategory) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.eventBadge = eventBadge;
        this.mainCategory = mainCategory;
    }
}
