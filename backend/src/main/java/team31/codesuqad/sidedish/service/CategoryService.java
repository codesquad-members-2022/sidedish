package team31.codesuqad.sidedish.service;

import org.springframework.stereotype.Service;
import team31.codesuqad.sidedish.controller.dto.AllCategoriesResponse;
import team31.codesuqad.sidedish.controller.dto.CategoryResponse;
import team31.codesuqad.sidedish.controller.dto.DishDto;
import team31.codesuqad.sidedish.domain.Category;
import team31.codesuqad.sidedish.domain.Dishes;
import team31.codesuqad.sidedish.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private final DishesService dishesService;
    private final DiscountPoliciesService discountPoliciesService;

    public CategoryService(CategoryRepository categoryRepository, DishesService dishesService, DiscountPoliciesService discountPoliciesService) {
        this.categoryRepository = categoryRepository;
        this.dishesService = dishesService;
        this.discountPoliciesService = discountPoliciesService;
    }

    public AllCategoriesResponse findCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<Dishes> dishes = dishesService.findAll();

        discountPoliciesService.mappingDiscountPolicies(dishes);
        List<CategoryResponse> allCategories = getCategoryResponses(categories, dishes);
        return new AllCategoriesResponse(allCategories);
    }

    private List<CategoryResponse> getCategoryResponses(List<Category> categories, List<Dishes> dishes) {
        List<CategoryResponse> allCategories = new ArrayList<>();
        for (Category category : categories) {
            List<Dishes> dishesList = dishes.stream()
                    .filter(dish -> dish.isSameCategory(category))
                    .collect(Collectors.toList());

            List<DishDto> dishDtos = dishesService.makeDishDto(dishesList);
            allCategories.add(new CategoryResponse(category, dishDtos));
        }

        return allCategories;
    }

}
