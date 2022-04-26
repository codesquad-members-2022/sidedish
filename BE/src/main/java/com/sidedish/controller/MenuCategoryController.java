package com.sidedish.controller;

import com.sidedish.dto.MenuCategoryListDto;
import com.sidedish.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @GetMapping("menu-categories/{range}/sidedishes")
    public MenuCategoryListDto getMenuCategories(@PathVariable String range) {
        return menuCategoryService.getMenuCategories(range);
    }
}
