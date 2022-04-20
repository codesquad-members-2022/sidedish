package com.sidedish.dto;

import lombok.Getter;

@Getter
public class EventCategoryDto {

    private Long id;
    private String name;

    public EventCategoryDto(Long eventCategoryId, String eventCategoryName) {
        this.id = eventCategoryId;
        this.name = eventCategoryName;
    }
}
