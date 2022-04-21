package com.codesquad.sidedish.category;

import com.codesquad.sidedish.dish.DishRepository;
import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    public List<CategoryResponse> groupDishBySection(String sectionName) {
        List<Dish> dishes = dishRepository.findBySectionName(sectionName);
        List<Category> categories = categoryRepository.findBySectionName(sectionName);

        Map<Integer, List<Dish>> dishMap = dishes.stream()
            .collect(Collectors.groupingBy(Dish::getCategoryId));

        for (Category category : categories) {
            category.setDishes(dishMap.get(category.getId()));
        }
        return categories.stream()
            .map(CategoryResponse::from)
            .collect(Collectors.toList());
    }
}
