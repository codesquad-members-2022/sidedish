package com.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "orders")
public class Order {

    @Id
    private Long id;
    private BigDecimal shippingFee;
    private String shippingInfo;

    public Long getId() {
        return this.id;
    }

    public Order(BigDecimal shippingFee, String shippingInfo) {
        this.shippingFee = shippingFee;
        this.shippingInfo = shippingInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shippingFee=" + shippingFee +
                ", shippingInfo='" + shippingInfo + '\'' +
                '}';
    }

    public String getInfo() {
        return this.shippingInfo;
    }
}
