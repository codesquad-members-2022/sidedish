package com.example.be.controller.dish;

import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryType;
import com.example.be.domain.dish.Dish;
import com.example.be.domain.dish.DishStatus;

import java.math.BigDecimal;

public class DishDetail {
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

    public DishDetail(Dish dish) {
        this.dishId = dish.getDishId();
        this.name = dish.getName();
        this.description = dish.getDescription();
        this.normalPrice = dish.getNormalPrice();
        this.salePrice = dish.getSalePrice();
        this.badge = dish.getBadge();
        this.deliveryType = dish.getDeliveryType();
        this.thumbnail = dish.getThumbnail();
        this.dishStatus = dish.getDishStatus();
        this.categoryId = dish.getCategoryId();
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
