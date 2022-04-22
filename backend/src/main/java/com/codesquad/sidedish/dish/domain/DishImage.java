package com.codesquad.sidedish.dish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@AllArgsConstructor
@ToString
public class DishImage {

    @Id
    @Column("dish_image_id")
    private Integer id;

    private final String imagePath;
    private final Integer sequence;
}
