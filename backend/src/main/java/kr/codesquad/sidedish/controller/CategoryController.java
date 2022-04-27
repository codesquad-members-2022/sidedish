package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.controller.dto.CategoryListResponse;
import kr.codesquad.sidedish.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public CategoryListResponse listCategories() {
        return new CategoryListResponse(categoryService.readAll());
    }
}
