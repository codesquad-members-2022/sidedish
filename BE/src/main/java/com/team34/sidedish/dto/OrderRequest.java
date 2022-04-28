package com.team34.sidedish.dto;

public class OrderRequest {

    private Long dishId;
    private int quantity;
    private int totalAmount;

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
