package com.terria.sidedish.service;

import com.terria.sidedish.domain.Category;
import com.terria.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findByExhibitionId(long exhibitionId) {
        return categoryRepository.findByExhibitionId(exhibitionId);
    }
}
