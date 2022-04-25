package com.codesquad.sidedish.category;

import com.codesquad.sidedish.category.dto.CategoryResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> findCategories(
        @RequestParam(value = "festival", required = false) String festivalName,
        @RequestParam(value = "section", required = false) String sectionName
    ) {
        if (festivalName != null) {
            return categoryService.groupDishBySection(festivalName.replace("-", " "));
        }
        if (sectionName != null) {
            return categoryService.groupDishBySection(sectionName.replace("-", " "));
        }
        return List.of();
    }
}
