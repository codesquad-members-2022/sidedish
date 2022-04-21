package com.codesquad.sidedish.dish.domain;

import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
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

    private final Integer categoryId;
    private final String title;
    private final String description;
    private final Integer price;
    private final Integer stock;

    // relation
    @Transient
    private List<EventBadge> eventBadges;
    @Transient
    private DishImage dishImage;

    public Dish(Integer id, String title, String description, Integer price, Integer stock,
        Integer categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    public void setEventBadges(List<EventBadge> eventBadges) {
        this.eventBadges = eventBadges;
    }

    public void setDishImage(DishImage dishImage) {
        this.dishImage = dishImage;
    }

}
