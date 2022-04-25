package com.codesquad.sidedish.category;

import com.codesquad.sidedish.category.domain.Category;
import com.codesquad.sidedish.category.dto.CategoryResponse;
import com.codesquad.sidedish.dish.DishRepository;
import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    public List<CategoryResponse> groupDishBySection(String sectionName) {
        List<Category> categories = categoryRepository.findBySectionName(sectionName);
        List<Dish> dishes = dishRepository.findBySectionName(sectionName);

        return categories.stream()
            .map(category -> CategoryResponse.of(category, dishes))
            .collect(Collectors.toList());
    }
}
