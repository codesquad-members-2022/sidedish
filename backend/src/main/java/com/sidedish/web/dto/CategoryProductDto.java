package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryProductDto {
    private Long id;
    private String productName;
    private String description;
    private int earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private int discountRate;
    private String imageThumbnail;
}
