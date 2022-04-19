package com.terria.sidedish.domain;

import lombok.Getter;

@Getter
public class DiscountEvent {

    private long id;
    private String title;
    private double discountRate;

    // FK
    private long sideDishId;
}
