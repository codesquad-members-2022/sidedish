package com.codesquad.sidedish.dish;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
@ToString(of = {"eventBadgeName", "discount"})
public class EventBadge {

    @Id
    @Column(value = "event_badge_id")
    Integer id;

    private final String eventBadgeName;
    private final Float discount;

}
