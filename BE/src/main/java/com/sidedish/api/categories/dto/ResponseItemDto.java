package com.sidedish.api.categories.dto;

import com.sidedish.domain.Badge;
import com.sidedish.domain.Item;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ResponseItemDto {

    private String title;
    private String description;
    private BigDecimal price;
    private Badge badge;
    private BigDecimal discountPrice;

    public ResponseItemDto(Item item) {
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.discountPrice = price.subtract(price.multiply(BigDecimal.valueOf(item.getDiscountRate() / 100)));
        this.badge = item.getBadge();
    }
}
