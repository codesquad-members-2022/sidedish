package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Table("ORDERS")
public class OrdersEntity {

    @Id
    private Long id;
    private LocalDateTime orderDate;

    // N-1 연관관계 매핑
    private Long memberId;
}
