package com.team34.sidedish.service;

import com.team34.sidedish.domain.Badge;
import com.team34.sidedish.domain.Category;
import com.team34.sidedish.domain.Dish;
import com.team34.sidedish.dto.DishDetailResponse;
import com.team34.sidedish.dto.DishResponse;
import com.team34.sidedish.dto.DishesResponse;
import com.team34.sidedish.repository.CategoryRepository;
import com.team34.sidedish.repository.DishRepository;
import java.util.ArrayList;
import java.util.Collections;
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
            .forEach(dish -> {
                DishResponse dishResponse = new DishResponse(dish);
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

    public DishDetailResponse dishDetail(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow();
        List<Dish> dishes = dishRepository.findAll();
        // TODO: 추천 아이템 로직 개선(다른 카테고리의 상품이 추천되도록)
        Collections.shuffle(dishes);
        List<Dish> recommendedDishes = dishes.subList(0, 10);
        return new DishDetailResponse(dish, recommendedDishes);
    }
}
