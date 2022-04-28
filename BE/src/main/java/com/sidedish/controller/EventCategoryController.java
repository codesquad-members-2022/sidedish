package com.sidedish.controller;

import com.sidedish.dto.EventCategoryListDto;
import com.sidedish.dto.SideDishListDto;
import com.sidedish.service.EventCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @GetMapping("event-categories")
    public EventCategoryListDto getEventCategories() {
        return eventCategoryService.getEventCategories();
    }
}
