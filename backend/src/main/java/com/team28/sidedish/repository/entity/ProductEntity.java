package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("PRODUCT")
public class ProductEntity {

    @Id
    private Long id;
    private String name;
    private Long price;
    private int stockQuantity;
    private String description;
    private double savePointRatio;

    // N-1 관계 매핑
    private Long categoryId;
    private Long discountId;
}
