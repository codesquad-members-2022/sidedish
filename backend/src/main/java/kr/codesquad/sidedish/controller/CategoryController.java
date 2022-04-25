package kr.codesquad.sidedish.controller;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.controller.dto.CategoryListResponse;
import kr.codesquad.sidedish.controller.dto.CategoryListResponse.SubElement;
import kr.codesquad.sidedish.controller.dto.ThemeListResponse;
import kr.codesquad.sidedish.controller.dto.ThemeListResponse.Element;
import kr.codesquad.sidedish.domain.Category;
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
        List<CategoryListResponse.Element> elements = categoryService.readAll()
            .stream()
            .map(this::entityToDTO)
            .collect(Collectors.toList());

        return new CategoryListResponse(elements);
    }

    private CategoryListResponse.Element entityToDTO(Category category) {
        List<SubElement> subElements = category.getSubcategories().stream()
            .map(subcategory -> new CategoryListResponse.SubElement(subcategory.getId(), subcategory.getName()))
            .collect(Collectors.toList());

        return new CategoryListResponse.Element(
            category.getId(),
            category.getName(),
            category.getDescription(),
            subElements);
    }
}
