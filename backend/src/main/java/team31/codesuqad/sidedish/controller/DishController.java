package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.*;
import team31.codesuqad.sidedish.controller.dto.DetailedDishDto;
import team31.codesuqad.sidedish.controller.dto.RecommandDto;
import team31.codesuqad.sidedish.service.DishesService;

@RestController
@RequestMapping("/api/dish")
public class DishController {

    private final DishesService dishesService;

    public DishController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping("/detail/{dish_id}")
    public DetailedDishDto showDetailedDish(@PathVariable("dish_id") Long dishId) {
        return dishesService.findById(dishId);
    }

    @GetMapping("/recommand")
    public RecommandDto showRecommandDishes(@RequestParam("page") Integer page) {
        return dishesService.findSideDishes(page);
    }

}
