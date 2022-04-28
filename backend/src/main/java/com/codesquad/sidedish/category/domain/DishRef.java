package com.codesquad.sidedish.category.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@Table("dish_category")
public class DishRef {

    private Integer dishId;
}
