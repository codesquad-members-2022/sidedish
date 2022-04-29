package com.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "orders")
public class Order {

    @Id
    private Long id;
    private BigDecimal shippingFee;
    private String shippingAddress;

    public Long getId() {
        return this.id;
    }

    public Order(BigDecimal shippingFee, String shippingAddress) {
        this.shippingFee = shippingFee;
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shippingFee=" + shippingFee +
                ", shippingInfo='" + shippingAddress + '\'' +
                '}';
    }

    public String getInfo() {
        return this.shippingAddress;
    }
}
