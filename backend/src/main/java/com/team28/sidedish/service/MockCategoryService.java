package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.CategoryResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockCategoryService implements CategoryService {

    @Override
    public List<CategoryResponse> findAll() {
        List<CategoryResponse> categories = new ArrayList<>();

        categories.add(new CategoryResponse(1L, "메인요리"));
        categories.add(new CategoryResponse(2L, "국물요리"));
        categories.add(new CategoryResponse(3L, "밑반찬"));

        return categories;
    }
}
