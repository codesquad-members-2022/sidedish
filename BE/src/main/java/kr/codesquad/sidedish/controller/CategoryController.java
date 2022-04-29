package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.interceptor.OrderInterceptor;
import kr.codesquad.sidedish.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategorizedDishes> showCategorizedDishes(@PathVariable Long categoryId,
                                                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                                                   @RequestParam(value = "size", defaultValue = "15") int size) {
        log.info("request categorizedDishes category[{}]", categoryId);
        CategorizedDishes categorizedDishes = categoryService.findDishesByCategoryId(categoryId, page, size);

        return ResponseEntity.ok(categorizedDishes);
    }

}
