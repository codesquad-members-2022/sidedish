package com.example.be.business.category.service;

import com.example.be.business.category.repository.CategoryRepository;
import com.example.be.business.dish.service.CategoryType;
import com.example.be.business.dish.service.DishInformationResponse;
import com.example.be.business.dish.service.InMemogryDatabase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final InMemogryDatabase inMemogryDatabase;

    public CategoryService(CategoryRepository categoryRepository, InMemogryDatabase inMemogryDatabase) {
        this.categoryRepository = categoryRepository;
        this.inMemogryDatabase = inMemogryDatabase;
    }

    @Transactional(readOnly = true)
    public Map<CategoryType, List<DishInformationResponse>> getDishesByCategory() {
        if (inMemogryDatabase.planningDataisEmpty()) {
            inMemogryDatabase.savePlanningData(categoryRepository.getDishesByCategory());
            return inMemogryDatabase.getPlanningDataByCategory();
        }
        return inMemogryDatabase.getPlanningDataByCategory();
    }

    @Transactional(readOnly = true)
    public Map<Long, List<DishInformationResponse>> getDishesBySubCategory(Long id) {
        if (inMemogryDatabase.planningDataisEmpty()) {
            inMemogryDatabase.savePlanningData(categoryRepository.getDishesByCategory());
            return inMemogryDatabase.getPlanningDataBySubCategory(id);
        }
        return inMemogryDatabase.getPlanningDataBySubCategory(id);
    }
}
