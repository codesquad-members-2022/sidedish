package com.sidedish.domain;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("item_order")
public class OrderRef {

    @Column("orders")
    private Long order;

    public OrderRef(Long order) {
        this.order = order;
    }

    public Long getOrder() {
        return order;
    }
}
