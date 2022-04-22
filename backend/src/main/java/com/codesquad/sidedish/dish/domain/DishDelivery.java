package com.codesquad.sidedish.dish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class DishDelivery {

    @Id
    @Column("delivery_id")
    private Integer deliveryId;
}
