package com.example.be.domain;

import java.math.BigDecimal;

public class Dish {
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private Badge badge;
    private DeliveryType deliveryType;
    private String thumbnail;
    private DishStatus dishStatus;
    private Long categoryId;

    public Dish(Long dishId, String name, String description, BigDecimal normalPrice, BigDecimal salePrice, Badge badge, DeliveryType deliveryType, String thumbnail, DishStatus dishStatus, Long categoryId) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.salePrice = salePrice;
        this.badge = badge;
        this.deliveryType = deliveryType;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.categoryId = categoryId;
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

    public Badge getBadge() {
        return badge;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
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
}
