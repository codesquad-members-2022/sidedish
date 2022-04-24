package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class CategoryDish {

    @Id
    private Long id;

    private Category category;
    private Dish dish;
}
