package com.example.be.controller.dish.dto;

import com.example.be.domain.dish.Dish;

import java.math.BigDecimal;

public class DishSaveResponse {
    private Long id;
    private String name;
    private BigDecimal normalPrice;

    public DishSaveResponse(Dish dish) {
        this.id = dish.getDishId();
        this.name = dish.getName();
        this.normalPrice = dish.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }
}
