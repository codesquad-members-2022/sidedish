package com.terria.sidedish.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderSheet {

    private long id;
    private int quantity;
    private double totalAmount;
    private LocalDateTime createdAt;

    // FK
    private long sideDishId;
    private long memberId;
    private long shippingId;
}
