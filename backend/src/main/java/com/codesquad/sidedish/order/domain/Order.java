package com.codesquad.sidedish.order.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {

    @Id
    private Integer id;
    private Integer amount;

    @Column("ORDER_DATE_TIME")
    private LocalDateTime orderDateTime;

    @Column("ITEM_ID")
    private Integer itemId;

    @Column("USER_ID")
    private Integer userId;

    private boolean isCancelled;

    public Order(Integer id, Integer amount, LocalDateTime orderDateTime, Integer itemId, Integer userId,
        boolean isCancelled) {
        this.id = id;
        this.amount = amount;
        this.orderDateTime = orderDateTime;
        this.itemId = itemId;
        this.userId = userId;
        this.isCancelled = isCancelled;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public Integer getItemId() {
        return itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", amount=" + amount +
            ", orderDateTime=" + orderDateTime +
            ", itemId=" + itemId +
            ", userId=" + userId +
            ", cancelled=" + isCancelled +
            '}';
    }
}
