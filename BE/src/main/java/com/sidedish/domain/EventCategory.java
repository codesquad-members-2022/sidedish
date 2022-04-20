package com.sidedish.domain;

import com.sidedish.dto.EventCategoryDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("event_category")
public class EventCategory {

    @Id
    private Long id;
    private Long eventId;
    private String name;

    public EventCategory(Long id, Long eventId, String name) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
    }

    public EventCategoryDto convertToDto() {
        return new EventCategoryDto(id, name);
    }
}
