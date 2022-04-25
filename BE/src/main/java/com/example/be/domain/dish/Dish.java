package com.example.be.domain.dish;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;


@Table("dish")
public class Dish {
    @Id
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private Badge badge;
    private DeliveryType deliveryType;
    private String thumbnail;
    private int count;
    private DishStatus dishStatus;

    public Dish(String name, String description, BigDecimal normalPrice, Badge badge, DeliveryType deliveryType, String thumbnail, DishStatus dishStatus, int count) {
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.badge = badge;
        this.deliveryType = deliveryType;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.count = count;
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

    public int getCount() {
        return count;
    }
}
