package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class EventCategoryListDto {

    private String eventName;
    private List<EventCategoryDto> eventCategories;

    public EventCategoryListDto(String eventName, List<EventCategoryDto> eventCategories) {
        this.eventName = eventName;
        this.eventCategories = eventCategories;
    }
}
