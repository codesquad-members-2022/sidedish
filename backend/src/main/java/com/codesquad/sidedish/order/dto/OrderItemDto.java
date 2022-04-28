package com.codesquad.sidedish.order.dto;

import java.time.LocalDateTime;

import com.codesquad.sidedish.order.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;

public class OrderItemDto {
    @Schema(description = "Item 번호", example = "1")
    private Integer itemId;
    @Schema(hidden = true)
    private Integer userId;
    @Schema(description = "구매 수량", example = "2")
    private Integer amount;

    public OrderItemDto() {
    }

    public OrderItemDto(Integer itemId, Integer amount) {
        this.itemId = itemId;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order toEntity() {
        return new Order(null, amount, LocalDateTime.now(), itemId, userId, false);
    }
}
