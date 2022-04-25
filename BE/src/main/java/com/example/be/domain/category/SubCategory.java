package com.example.be.domain.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("sub_category")
public class SubCategory {

    @Id
    private Long subCategoryId;
    private String name;

    public SubCategory(String name) {
        this.name = name;
    }
}
