package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorizedDishes> findCategorizedById(@PathVariable Long id) {
        CategorizedDishes categorizedDishes = categoryService.findDishesByCategoryId(id);

        return ResponseEntity.ok(categorizedDishes);
    }

}
