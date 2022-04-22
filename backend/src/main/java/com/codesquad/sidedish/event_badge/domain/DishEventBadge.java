package com.codesquad.sidedish.event_badge.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
public class DishEventBadge {

    @Id
    @Column("dish_id")
    private Integer dishId;

    private Integer eventBadgeId;
}
