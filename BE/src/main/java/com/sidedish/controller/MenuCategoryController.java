package com.sidedish.controller;

import com.sidedish.dto.MenuCategoryListDto;
import com.sidedish.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @GetMapping("first-menu-category")
    public MenuCategoryListDto getFirstMenuCategories() {
        return menuCategoryService.findFirstMenuCategoryWithSideDishes();
    }

    @GetMapping("rest-menu-categories")
    public MenuCategoryListDto getRestOfMenuCategories() {
        return menuCategoryService.findRestOfCategoryWithSideDishes();
    }

}
