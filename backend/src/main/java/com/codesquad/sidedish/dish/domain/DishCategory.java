package com.codesquad.sidedish.dish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class DishCategory {

    @Id
    @Column("category_id")
    private Integer categoryId;

}
