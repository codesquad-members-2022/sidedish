package com.team28.sidedish.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@AllArgsConstructor
@Table("CATEGORY")
public class CategoryEntity {

    @Id
    private Long id;
    private String code;
    private String name;
    @MappedCollection(idColumn = "CATEGORY_ID")
    private Set<ProductEntity> products;
}
