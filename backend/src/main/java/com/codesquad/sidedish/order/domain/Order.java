package com.codesquad.sidedish.order.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class Order {

    @Id
    private Integer id;
    private Integer amount;

    @Column("ORDER_DATE")
    private LocalDateTime orderDate;

    @Column("ITEM_ID")
    private Integer itemId;

    @Column("USER_ID")
    private Integer userId;

    private Boolean cancelled;

    public Order(Integer id, Integer amount, LocalDateTime orderDate, Integer itemId, Integer userId,
        Boolean cancelled) {
        this.id = id;
        this.amount = amount;
        this.orderDate = orderDate;
        this.itemId = itemId;
        this.userId = userId;
        this.cancelled = cancelled;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public Integer getUserId() {
        return userId;
    }


    public static Order from(Integer amount, LocalDateTime orderDate, Integer itemId, Integer userId) {
        return new Order(null, amount, orderDate, itemId, userId, false);
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", amount=" + amount +
            ", orderDate=" + orderDate +
            ", itemId=" + itemId +
            ", userId=" + userId +
            ", cancelled=" + cancelled +
            '}';
    }
}
