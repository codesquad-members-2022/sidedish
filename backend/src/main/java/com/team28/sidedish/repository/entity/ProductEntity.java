package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@AllArgsConstructor
@Table("PRODUCT")
public class ProductEntity {

    @Id
    private Long id;
    private Long discountId;
    private String name;
    private Long price;
    private int stockQuantity;
    private String description;
    private double savePointRatio;
    @MappedCollection(idColumn = "PRODUCT_ID")
    private Set<ProductImageEntity> productImages;

    public void decreaseStock(int stockQuantity) {
        this.stockQuantity -= stockQuantity;
    }
}
