package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class CategoryDish {

    @Id
    private Long id;

    private Long categoryId;
    private Long dishId;
}
