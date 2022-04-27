package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import com.sidedish.domain.product.EventCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventCategoryProductDto {
    private String productName;
    private String description;
    private int earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private double discountRate;
    private EventCategory eventCategory;
}
