package com.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table("event_category")
public class EventCategory {

    @Id
    private Integer id;
    private Integer eventId;
    private String name;


}
