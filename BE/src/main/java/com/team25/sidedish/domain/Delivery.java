package com.team25.sidedish.domain;

import lombok.Getter;

@Getter
public class Delivery {

    private Long id;
    private String region;
    private DeliveryType type;
    private int freePrice;
    private int fee;

}
