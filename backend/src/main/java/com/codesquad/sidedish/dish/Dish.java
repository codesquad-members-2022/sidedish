package com.codesquad.sidedish.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(of = {"title", "description", "price", "stock"})
public class Dish {

    @Id
    @Column(value = "dish_id")
    private Integer id;
    private Integer eventBadgeId;

    private final String title;
    private final String description;
    private final Integer price;
    private final Integer stock;

    // relation
    private EventBadge eventBadge;

    public void setEventBadge(EventBadge eventBadge) {
        this.eventBadgeId = eventBadge.getId();
    }
}
