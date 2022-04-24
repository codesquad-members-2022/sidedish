package com.codesquad.sidedish.category;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
public class Category {

    @Id
    @Column("category_id")
    private Integer id;

    private Integer sectionId;
    private String categoryName;
    private Boolean isFestival;

    // relation
    @Transient
    private List<Dish> dishes;

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
