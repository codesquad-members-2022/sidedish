package com.team34.sidedish.controller;

import com.team34.sidedish.dto.DishDetailResponse;
import com.team34.sidedish.dto.DishesResponse;
import com.team34.sidedish.service.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public DishesResponse dishes() {
        return dishService.dishes();
    }

    @GetMapping("/{id}")
    public DishDetailResponse dishDetail(@PathVariable Long id) {
        return dishService.dishDetail(id);
    }
}
