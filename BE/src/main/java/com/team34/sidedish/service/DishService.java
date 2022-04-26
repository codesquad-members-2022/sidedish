package com.team34.sidedish.service;

import com.team34.sidedish.domain.Category;
import com.team34.sidedish.domain.Dish;
import com.team34.sidedish.dto.DishResponse;
import com.team34.sidedish.dto.DishesResponse;
import com.team34.sidedish.repository.CategoryRepository;
import com.team34.sidedish.repository.DishRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    public DishService(DishRepository dishRepository, CategoryRepository categoryRepository) {
        this.dishRepository = dishRepository;
        this.categoryRepository = categoryRepository;
    }

    public DishesResponse dishes() {
        List<DishResponse> eventItems = new ArrayList<>();
        List<DishResponse> items = new ArrayList<>();

        dishRepository.findAll()
            .iterator()
            .forEachRemaining(dish -> {
                DishResponse dishResponse = dish.toDishResponse();
                if (isEventDish(dish)) {
                    eventItems.add(dishResponse);
                }
                items.add(dishResponse);
            });

        return new DishesResponse(eventItems, items);
    }

    private boolean isEventDish(Dish dish) {
        return dish.categoryIds()
            .stream()
            .map(categoryRepository::findById)
            .map(Optional::orElseThrow)
            .anyMatch(Category::isEvent);
    }
}
