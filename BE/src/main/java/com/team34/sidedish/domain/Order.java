package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private Long id;

    private final Member member;
    private final Dish dish;
    private final int quantity;
    private final int totalAmount;

    public Order(Long id, Member member, Dish dish, int quantity, int totalAmount) {
        this.id = id;
        this.member = member;
        this.dish = dish;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", member=" + member +
            ", dish=" + dish +
            ", quantity=" + quantity +
            ", totalAmount=" + totalAmount +
            '}';
    }
}
