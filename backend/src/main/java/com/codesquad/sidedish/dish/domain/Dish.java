package com.codesquad.sidedish.dish.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
public class Dish {

    @Id
    @Column(value = "dish_id")
    private Integer id;

    private String title;
    private String description;
    private Integer price;
    private Integer stock;

    // 연관관계 수동 매핑 필드
    @Transient
    private Integer categoryId;
    @Transient
    private DishImage dishImage;

    private Dish() {
    }

    public Dish(Integer id, String title, String description, Integer price, Integer stock,
        Integer categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    public void setDishImage(DishImage dishImage) {
        this.dishImage = dishImage;
    }

}
