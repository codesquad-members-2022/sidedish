package com.example.be.business.dish.controller;

import com.example.be.business.dish.domain.Badge;
import com.example.be.business.dish.domain.DeliveryPriceOption;
import com.example.be.business.dish.domain.DishStatus;

import java.math.BigDecimal;

public class DishUpdateRequest {
    private String description;
    private BigDecimal price;
    private Badge badge;
    private DeliveryPriceOption deliveryPriceOption;
    private String thumbnail;
    private DishStatus dishStatus;
    private Long categoryId;
    private int count;

    public DishUpdateRequest(String description, BigDecimal price, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus, Long categoryId, int count) {
        this.description = description;
        this.price = price;
        this.badge = badge;
        this.deliveryPriceOption = deliveryPriceOption;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.categoryId = categoryId;
        this.count = count;
    }

    public DishUpdateRequest() {
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Badge getBadge() {
        return badge;
    }

    public DeliveryPriceOption getDeliveryPriceOption() {
        return deliveryPriceOption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public int getCount() {
        return count;
    }
}
