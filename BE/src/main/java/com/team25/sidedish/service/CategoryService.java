package com.team25.sidedish.service;

import com.team25.sidedish.domain.Category;
import com.team25.sidedish.exception.CategoryNotExistException;
import com.team25.sidedish.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void validCategoryExist(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isEmpty()) {
            throw new CategoryNotExistException();
        }
    }
}
