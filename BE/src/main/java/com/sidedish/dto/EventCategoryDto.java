package com.sidedish.dto;

import lombok.Getter;

@Getter
public class EventCategoryDto {

    private Integer id;
    private String name;

    public EventCategoryDto(Integer eventCategoryId, String eventCategoryName) {
        this.id = eventCategoryId;
        this.name = eventCategoryName;
    }
}
