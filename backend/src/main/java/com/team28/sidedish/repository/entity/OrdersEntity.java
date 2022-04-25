package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
@Table("ORDERS")
public class OrdersEntity {

    @Id
    private Long id;
    private Long memberId;
    private LocalDateTime orderDate;
    @MappedCollection(idColumn = "ORDER_ID")
    private Set<OrderProductsEntity> orderProducts;
}
