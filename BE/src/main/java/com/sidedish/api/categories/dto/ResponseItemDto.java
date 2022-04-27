package com.sidedish.api.categories.dto;

import com.sidedish.domain.Badge;
import com.sidedish.domain.Images;
import com.sidedish.domain.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Getter;

@Getter
public class ResponseItemDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Badge badge;
    private BigDecimal discountPrice;
    private BigDecimal rewardPoint;
    private Images images;

    public ResponseItemDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.badge = item.getBadge();
        this.discountPrice = price.subtract(price.multiply(BigDecimal.valueOf(item.getDiscountRate() / 100)).setScale(0, RoundingMode.FLOOR));
        this.rewardPoint = item.getRewardPoint();
        this.images = item.getImage();
    }
}
