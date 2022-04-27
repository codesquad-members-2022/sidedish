package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team31.codesuqad.sidedish.controller.dto.CategoryNames;
import team31.codesuqad.sidedish.service.CategoryService;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/dish/categorynames")
    public CategoryNames getCategoryNames() {
        return categoryService.findAll();
    }

}
