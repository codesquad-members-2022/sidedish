package com.codesquad.sidedish.event_badge.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@Table("dish_event_badge")
public class DishRef {

    private Integer dishId;
    private Integer eventBadgeId;

}
