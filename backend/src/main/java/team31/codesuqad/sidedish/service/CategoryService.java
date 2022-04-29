package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team31.codesuqad.sidedish.controller.dto.AllCategoriesResponse;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.domain.Category;
import team31.codesuqad.sidedish.domain.Dish;
import team31.codesuqad.sidedish.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DishService dishService;

    public CategoryService(CategoryRepository categoryRepository, DishService dishService) {
        this.categoryRepository = categoryRepository;
        this.dishService = dishService;
    }

    public AllCategoriesResponse findCategories() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryResponse> allCategories = new ArrayList<>();
        for (Category category : categories) {
            List<Dish> dishes = dishService.findAllByCategoryId(category.getId());
            allCategories.add(new CategoryResponse(category, dishes));
        }
        return new AllCategoriesResponse(allCategories);
    }

}
