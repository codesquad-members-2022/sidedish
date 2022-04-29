package com.example.be.business.dish.controller.dto;

import com.example.be.business.dish.domain.Badge;
import com.example.be.business.dish.domain.DeliveryPriceOption;
import com.example.be.business.dish.domain.DishStatus;

import java.math.BigDecimal;

public class PlanningDataRequest {
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private String badge;
    private String deliveryPriceOption;
    private String thumbnail;
    private String dishStatus;
    private String title;

    public PlanningDataRequest(Long dishId, String name, String description, BigDecimal normalPrice, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus, String title) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.badge = badge.name();
        this.deliveryPriceOption = deliveryPriceOption.name();
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus.name();
        this.title = title;
    }

    public Long getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public String getBadge() {
        return badge;
    }

    public String getDeliveryPriceOption() {
        return deliveryPriceOption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDishStatus() {
        return dishStatus;
    }

    public String getTitle() {
        return title;
    }
}
