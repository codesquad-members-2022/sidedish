package com.sidedish.mapper;

import com.sidedish.domain.EventCategory;
import com.sidedish.dto.EventCategoryDto;

public class EventCategoryMapper {

    public EventCategoryDto convertToDto(EventCategory eventCategory) {
        return new EventCategoryDto(eventCategory.getId(), eventCategory.getName());
    }

}
