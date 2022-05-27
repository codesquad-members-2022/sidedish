package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CategoryProductDto {
    private Long id;
    private String productName;
    private String description;
    private boolean earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private int discountRate;
    private String imageThumbnail;
}
