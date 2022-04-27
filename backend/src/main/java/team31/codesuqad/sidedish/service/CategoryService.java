package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.controller.dto.CategoryNames;
import team31.codesuqad.sidedish.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryNames findAll() {
        return new CategoryNames(categoryRepository.findAll());
    }
}
