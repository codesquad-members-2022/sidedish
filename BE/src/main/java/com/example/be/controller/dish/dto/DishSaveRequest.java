package com.example.be.controller.dish.dto;

import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryType;
import com.example.be.domain.dish.Dish;
import com.example.be.domain.dish.DishStatus;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class DishSaveRequest {
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private Badge badge;
    private DeliveryType deliveryType;
    private String thumbnail;
    private DishStatus dishStatus;
    private int count;

    public DishSaveRequest(String name, String description, BigDecimal normalPrice, BigDecimal salePrice, Badge badge, DeliveryType deliveryType, String thumbnail, DishStatus dishStatus, int count) {
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.salePrice = salePrice;
        this.badge = badge;
        this.deliveryType = deliveryType;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.count = count;
    }

    public Dish toEntity() {
        return new Dish(name, description, normalPrice, badge, deliveryType, thumbnail, dishStatus, count);
    }

    @Getter
    public static class Response {
        private String name;
        private BigDecimal normalPrice;

        public Response(Dish dish) {
            this.name = dish.getName();
            this.normalPrice = dish.getNormalPrice();
        }

        public String getName() {
            return name;
        }

        public BigDecimal getNormalPrice() {
            return normalPrice;
        }
    }
}
