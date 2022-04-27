package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.controller.dto.CategoryListResponse;
import kr.codesquad.sidedish.domain.Category;
import kr.codesquad.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryListResponse.Element> readAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private CategoryListResponse.Element entityToDTO(Category category) {
        List<CategoryListResponse.SubElement> subElements = category.getSubcategories().stream()
            .map(subcategory -> new CategoryListResponse.SubElement(subcategory.getId(), subcategory.getName()))
            .collect(Collectors.toList());

        return new CategoryListResponse.Element(
            category.getId(),
            category.getName(),
            category.getDescription(),
            subElements);
    }
}
