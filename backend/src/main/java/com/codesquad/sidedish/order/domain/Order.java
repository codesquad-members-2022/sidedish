package com.codesquad.sidedish.order.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.codesquad.sidedish.item.domain.Item;

public class Order {

    @Id
    private Integer id;
    private Integer amount;

    @Column("ORDER_DATE")
    private LocalDateTime orderDate;

    private Item item;

    private boolean cancelled;

    public Order(Integer id, Integer amount, LocalDateTime orderDate, Item item, boolean cancelled) {
        this.id = id;
        this.amount = amount;
        this.orderDate = orderDate;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
