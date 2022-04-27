package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team31.codesuqad.sidedish.controller.dto.AllCategoriesResponse;
import team31.codesuqad.sidedish.controller.dto.CategoryNames;
import team31.codesuqad.sidedish.service.CategoryService;

@RestController
@RequestMapping("/api/dish")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorynames")
    public CategoryNames getCategoryNames() {
        return categoryService.findAll();
    }

    @GetMapping("/categories")
    public AllCategoriesResponse getCategories() {
        return categoryService.findCategories();
    }

}
