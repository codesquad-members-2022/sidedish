package com.sidedish.domain;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ShipInfo {

    private final String shippingDescription;
    private final BigDecimal shippingFee;

    public ShipInfo(String shippingDescription, BigDecimal shippingFee) {
        this.shippingDescription = shippingDescription;
        this.shippingFee = shippingFee;
    }
}
