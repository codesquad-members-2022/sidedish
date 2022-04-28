package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team31.codesuqad.sidedish.controller.dto.AllCategoriesResponse;
import team31.codesuqad.sidedish.service.CategoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/dish/categories")
    public AllCategoriesResponse getCategories() {
        return categoryService.findCategories();
    }

}
