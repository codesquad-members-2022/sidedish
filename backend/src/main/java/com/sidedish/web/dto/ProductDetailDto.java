package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ProductDetailDto {
    private String productName;
    private int earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private Map<Long, String> imageList;
}
