package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import com.sidedish.domain.product.MainCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MainCategoryProductDto {
    private String productName;
    private String description;
    private int earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private MainCategory mainCategory;

    @Builder
    public MainCategoryProductDto(String productName, String description, int earlyDelivery, int price, EventBadge eventBadge, MainCategory mainCategory) {
        this.productName = productName;
        this.description = description;
        this.earlyDelivery = earlyDelivery;
        this.price = price;
        this.eventBadge = eventBadge;
        this.mainCategory = mainCategory;
    }
}
