package com.team25.sidedish.domain;

public enum DeliveryType {

    NORMAL("일반 배송"), DAWN("새벽 배송");

    private String name;

    DeliveryType(String name) {
        this.name = name;
    }
}
