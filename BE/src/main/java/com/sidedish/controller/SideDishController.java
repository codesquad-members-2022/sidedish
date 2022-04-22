package com.sidedish.controller;

import com.sidedish.dto.SideDishListDto;
import com.sidedish.service.SideDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SideDishController {

    private final SideDishService sideDishService;

    @GetMapping("event-categories/sidedishes")
    public SideDishListDto getSideDishes(@RequestParam("eventCategoryId") Integer eventCategoryId) {
        return sideDishService.getSideDishList(eventCategoryId);
    }

}
