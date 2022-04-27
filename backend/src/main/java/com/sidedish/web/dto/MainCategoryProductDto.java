package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import com.sidedish.domain.product.MainCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MainCategoryProductDto {
    private String productName;
    private String description;
    private int earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private MainCategory mainCategory;
}
