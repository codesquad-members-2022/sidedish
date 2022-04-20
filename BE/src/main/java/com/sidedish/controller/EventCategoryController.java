package com.sidedish.controller;

import com.sidedish.dto.EventCategoryListDto;
import com.sidedish.service.EventCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @GetMapping("event-categories")
    public EventCategoryListDto getEventCategories() {
        return eventCategoryService.getEventCategories();
    }

}
