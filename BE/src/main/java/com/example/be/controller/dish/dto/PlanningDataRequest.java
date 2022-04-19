package com.example.be.controller.dish.dto;

import com.example.be.domain.Badge;
import com.example.be.domain.DeliveryType;
import com.example.be.domain.DishStatus;

import java.math.BigDecimal;

public class PlanningDataRequest {
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private String badge;
    private String deliveryType;
    private String thumbnail;
    private String dishStatus;
    private Long categoryId;
    private String title;

    public PlanningDataRequest(Long dishId, String name, String description, BigDecimal normalPrice, BigDecimal salePrice, Badge badge, DeliveryType deliveryType, String thumbnail, DishStatus dishStatus, Long categoryId, String title) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.salePrice = salePrice;
        this.badge = badge.name();
        this.deliveryType = deliveryType.name();
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus.name();
        this.categoryId = categoryId;
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

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public String getBadge() {
        return badge;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDishStatus() {
        return dishStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }
}
