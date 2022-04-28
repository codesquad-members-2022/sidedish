package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class CategoryDish {

    @Id
    private Long id;

    private final Long categoryId;
    private final Long dishId;

    public CategoryDish(Long id, Long categoryId, Long dishId) {
        this.id = id;
        this.categoryId = categoryId;
        this.dishId = dishId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
