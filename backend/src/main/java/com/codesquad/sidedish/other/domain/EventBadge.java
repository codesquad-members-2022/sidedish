package com.codesquad.sidedish.other.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class EventBadge {

    @Id
    @Column(value = "event_badge_id")
    Integer id;

    private final String eventBadgeName;
    private final Float discount;

}
