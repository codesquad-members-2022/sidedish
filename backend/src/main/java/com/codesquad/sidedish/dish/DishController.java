package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping
    public List<Dish> findDishes(
        @RequestParam(value = "section", required = false) String sectionName,
        @RequestParam(value = "category", required = false) String categoryName,
        @RequestParam(value = "flat", defaultValue = "true", required = false) Boolean flat
    ) {
        if (sectionName != null && flat) {
            return dishService.findDishBySection(sectionName);
        }
        if (categoryName != null && flat) {
            return dishService.findDishByCategory(categoryName);
        }
        return null;
    }
}
