package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("ORDER_PRODUCTS")
public class OrderProductsEntity {

    @Id
    private Long id;
    private Long orderId;
    private Long productID;
    private int quantity;
}
