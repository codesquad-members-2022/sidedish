package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategorizedDishes> showCategorizedDishes(@PathVariable Long categoryId,
                                                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        CategorizedDishes categorizedDishes = categoryService.findDishesByCategoryId(categoryId, page, size);

        return ResponseEntity.ok(categorizedDishes);
    }

}
