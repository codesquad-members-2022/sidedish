package com.codesquad.sidedish.order.dto;

import java.time.LocalDateTime;

import com.codesquad.sidedish.order.domain.Order;

public class OrderItemDto {

    private Integer itemId;
    private Integer userId;
    private Integer amount;

    public OrderItemDto(Integer itemId, Integer userId, Integer amount) {
        this.itemId = itemId;
        this.userId = userId;
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public Order toEntity() {
        return Order.from(amount, LocalDateTime.now(), itemId, userId);
    }

}
