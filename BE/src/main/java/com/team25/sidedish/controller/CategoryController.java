package com.team25.sidedish.controller;

import com.team25.sidedish.dto.response.CategoryResponse;
import com.team25.sidedish.service.CategoryService;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories().stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toUnmodifiableList());
    }

}
