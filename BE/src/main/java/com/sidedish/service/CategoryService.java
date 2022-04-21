package com.sidedish.service;

import com.sidedish.domain.Category;
import com.sidedish.domain.Item;
import com.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Item> findItemsByPageId(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 카테고리를 찾을 수 없습니다."));
        return category.getItems();
    }
}
