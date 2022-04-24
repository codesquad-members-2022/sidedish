package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private Long id;

    private Member member;
    private Dish dish;
    private int quantity;
    private int totalAmount;

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
