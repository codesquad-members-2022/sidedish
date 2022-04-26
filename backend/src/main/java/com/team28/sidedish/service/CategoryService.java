package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.CategoryResponse;
import com.team28.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryEntity -> CategoryResponse.of(categoryEntity.getId(), categoryEntity.getName()))
                .collect(Collectors.toUnmodifiableList());
    }
}
