package com.team34.sidedish.controller;

import com.team34.sidedish.dto.CategoriesResponse;
import com.team34.sidedish.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public CategoriesResponse categories(@RequestParam boolean isEvent) {
        return categoryService.getCategories(isEvent);
    }
}
