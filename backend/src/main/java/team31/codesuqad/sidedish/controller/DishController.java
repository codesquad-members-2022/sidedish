package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team31.codesuqad.sidedish.controller.dto.DetailedDishDto;
import team31.codesuqad.sidedish.service.DishesService;

@RestController
public class DishController {

    private final DishesService dishesService;

    public DishController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping("/api/dish/detail/{dish_id}")
    public DetailedDishDto showDetailedDish(@PathVariable("dish_id") Long dishId) {
        return dishesService.findById(dishId);
    }
}
