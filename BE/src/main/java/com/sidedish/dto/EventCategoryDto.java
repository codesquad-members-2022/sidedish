package com.sidedish.dto;

import lombok.Getter;

@Getter
public class EventCategoryDto {

    private final Integer id;
    private final String name;

    public EventCategoryDto(Integer eventCategoryId, String eventCategoryName) {
        this.id = eventCategoryId;
        this.name = eventCategoryName;
    }
}
