package team31.codesuqad.sidedish.controller;

import org.springframework.web.bind.annotation.*;
import team31.codesuqad.sidedish.controller.dto.DetailedDishDto;
import team31.codesuqad.sidedish.controller.dto.RecommendDto;
import team31.codesuqad.sidedish.service.DishService;

@RestController
@RequestMapping("/api/dish")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/detail/{dish_id}")
    public DetailedDishDto showDetailedDish(@PathVariable("dish_id") long dishId) {
        return dishService.findByDishId(dishId);
    }

    @GetMapping("/recommand")
    public RecommendDto showRecommendDishes(@RequestParam("page") int page) {
        return dishService.findRecommendDishes(page);
    }

}
