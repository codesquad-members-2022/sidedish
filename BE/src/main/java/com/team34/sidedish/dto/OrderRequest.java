package com.team34.sidedish.dto;

import com.team34.sidedish.domain.Order;

public class OrderRequest {

    private Long dishId;
    private int quantity;
    private int totalAmount;

    public Order toOrder() {
        return new Order(dishId, quantity, totalAmount);
    }

    public Long getDishId() {
        return dishId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
