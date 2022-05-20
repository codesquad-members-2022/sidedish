package com.sidedish.web.dto;

import com.sidedish.domain.product.EventBadge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ProductDetailDto {
    private String productName;
    private boolean earlyDelivery;
    private int price;
    private EventBadge eventBadge;
    private int discountRate;
    private List<ImageDto> image;
}
