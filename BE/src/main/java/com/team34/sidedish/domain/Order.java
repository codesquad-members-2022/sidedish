package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {

    @Id
    private Long id;

    private Long memberId;
    private Long dishId;
    private int quantity;
    private int totalAmount;

    public Order(Long dishId, int quantity, int totalAmount) {
        this.memberId = 1L; //Oauth 구현전이라 하드코딩으로 우선 작성한 상태입니다.
        this.dishId = dishId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", dishId=" + dishId +
            ", quantity=" + quantity +
            ", totalAmount=" + totalAmount +
            '}';
    }
}
