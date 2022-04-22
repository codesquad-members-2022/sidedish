package com.team25.sidedish.domain;

import lombok.Getter;

@Getter
public class Delivery {

    private Long id;
    private String region;
    private DeliveryType type;
    private int freePrice;
    private int fee;

    public Delivery(String region, DeliveryType type, int freePrice, int fee) {
        this.region = region;
        this.type = type;
        this.freePrice = freePrice;
        this.fee = fee;
    }
}
