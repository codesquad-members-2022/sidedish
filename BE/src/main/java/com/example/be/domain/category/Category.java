package com.example.be.domain.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("category")
public class Category {

    @Id
    private Long categoryId;
    private String title;

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

}
