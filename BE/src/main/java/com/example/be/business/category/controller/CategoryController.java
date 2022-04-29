package com.example.be.business.category.controller;

import com.example.be.business.category.service.CategoryService;
import com.example.be.business.dish.service.CategoryType;
import com.example.be.business.dish.service.DishInformationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Map<CategoryType, List<DishInformationResponse>>> getDishesByCategory() {
        Map<CategoryType, List<DishInformationResponse>> planningDataResponses = categoryService.getDishesByCategory();
        return new ResponseEntity<>(planningDataResponses, HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Map<Long, List<DishInformationResponse>>> getDishesBySubCategory(@PathVariable("categoryId") Long categoryId) {
        Map<Long, List<DishInformationResponse>> planningDataResponses = categoryService.getDishesBySubCategory(categoryId);
        return new ResponseEntity<>(planningDataResponses, HttpStatus.OK);
    }
}
