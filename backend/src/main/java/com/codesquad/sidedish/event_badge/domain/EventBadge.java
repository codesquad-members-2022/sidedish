package com.codesquad.sidedish.event_badge.domain;

import java.util.List;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
public class EventBadge {

    @Id
    @Column(value = "event_badge_id")
    Integer id;

    private String eventBadgeName;
    private Float discount;

    @MappedCollection(idColumn = "event_badge_id", keyColumn = "event_badge_id")
    private List<DishEventBadge> dishEventBadges;
}
