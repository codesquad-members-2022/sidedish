package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@AllArgsConstructor
@Table("PRODUCT_IMAGE")
public class ProductImageEntity {

    @Id
    private Long id;
    private String imagePath;
    private boolean representYn;
    private int sequence;
}
