package com.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("event_category")
public class EventCategory {

    @Id
    private Integer id;
    private Integer eventId;
    private String name;
}
