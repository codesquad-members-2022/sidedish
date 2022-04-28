package com.team34.sidedish.service;

import com.team34.sidedish.domain.Category;
import com.team34.sidedish.dto.CategoriesResponse;
import com.team34.sidedish.dto.CategoryResponse;
import com.team34.sidedish.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoriesResponse getCategories(boolean isEvent) {
        List<Category> categories = categoryRepository.findAllByIsEvent(isEvent);

        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category:categories) {
            categoryResponses.add(new CategoryResponse(category));
        }
        return new CategoriesResponse(categoryResponses);
    }
}
