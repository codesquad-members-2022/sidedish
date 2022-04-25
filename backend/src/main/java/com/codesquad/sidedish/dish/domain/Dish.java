package com.codesquad.sidedish.dish.domain;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
public class Dish {

    @Id
    @Column(value = "dish_id")
    private Integer id;

    private final String title;
    private final String description;
    private final Integer price;
    private final Integer stock;

    @MappedCollection(idColumn = "dish_id")
    private final Set<DishDiscount> dishDiscounts = new HashSet<>();

    @MappedCollection(idColumn = "dish_id")
    private final Set<DishImage> dishImages = new HashSet<>();

    public Dish(Integer id, String title, String description, Integer price, Integer stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

}
