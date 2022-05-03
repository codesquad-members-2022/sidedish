package com.example.be.business.category.service;

import com.example.be.business.category.repository.CategoryRepository;
import com.example.be.business.dish.service.CategoryType;
import com.example.be.business.dish.service.DishInformationResponse;
import com.example.be.business.dish.service.InMemoryDatabase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final InMemoryDatabase inMemoryDatabase;

    public CategoryService(CategoryRepository categoryRepository, InMemoryDatabase inMemoryDatabase) {
        this.categoryRepository = categoryRepository;
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Transactional(readOnly = true)
    public Map<CategoryType, List<DishInformationResponse>> getDishesByCategory() {
        if (inMemoryDatabase.planningDataisEmpty()) {
            inMemoryDatabase.savePlanningData(categoryRepository.getDishesByCategory());
            return inMemoryDatabase.getPlanningDataByCategory();
        }
        return inMemoryDatabase.getPlanningDataByCategory();
    }

    @Transactional(readOnly = true)
    public Map<Long, List<DishInformationResponse>> getDishesBySubCategory(Long id) {
        if (inMemoryDatabase.planningDataisEmpty()) {
            inMemoryDatabase.savePlanningData(categoryRepository.getDishesByCategory());
            return inMemoryDatabase.getPlanningDataBySubCategory(id);
        }
        return inMemoryDatabase.getPlanningDataBySubCategory(id);
    }
}
