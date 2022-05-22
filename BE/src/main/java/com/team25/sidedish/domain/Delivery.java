package com.team25.sidedish.domain;

import lombok.Getter;

@Getter
public class Delivery {

    public static int FEE = 2_500;
    public static int FREE_PRICE = 40_000;

    private Long id;
    private String region;
    private DeliveryType type;

    public Delivery(String region, DeliveryType type) {
        this.region = region;
        this.type = type;
    }
}
