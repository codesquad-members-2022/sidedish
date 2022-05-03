package com.example.be.business.category.controller.dto;

import com.example.be.business.dish.domain.Badge;
import com.example.be.business.dish.domain.DeliveryPriceOption;
import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.domain.DishStatus;

import java.math.BigDecimal;

public class PlanningDataResponse {

    private Long dishId;
    private String name;
    private String description;
    private BigDecimal price;
    private String badge;
    private String deliveryPriceOption;
    private String thumbnail;
    private String dishStatus;

    public PlanningDataResponse(Long dishId, String name, String description, BigDecimal price, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.badge = badge.name();
        this.deliveryPriceOption = deliveryPriceOption.name();
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus.name();
    }

    public PlanningDataResponse (Dish dish){
        this.dishId = dish.getDishId();
        this.name = dish.getName();
        this.description = dish.getDescription();
        this.price = dish.getPrice();
        this.badge = dish.getBadge().name();
        this.thumbnail = dish.getThumbnail();
        this.dishStatus = dish.getDishStatus().name();
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

    public BigDecimal getPrice() {
        return price;
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
}
