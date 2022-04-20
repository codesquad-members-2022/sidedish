package com.team34.sidedish.controller;

import com.team34.sidedish.dto.DishDetailResponse;
import com.team34.sidedish.dto.DishesResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @GetMapping
    public DishesResponse dishes() {
        return new DishesResponse();
    }

    @GetMapping("/{id}")
    public DishDetailResponse dishDetail(@PathVariable Long id) {
        return new DishDetailResponse();
    }
}
