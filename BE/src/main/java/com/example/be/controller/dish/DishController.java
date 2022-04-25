package com.example.be.controller.dish;

import com.example.be.controller.dish.dto.DishDetailResponse;
import com.example.be.controller.dish.dto.PlanningDataRequestByCategory;
import com.example.be.repository.category.CategoryRepository;
import com.example.be.service.dish.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;
    private final CategoryRepository categoryRepository;

    public DishController(DishService dishService, CategoryRepository categoryRepository) {
        this.dishService = dishService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<DishDetailResponse> getDishDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new DishDetailResponse(dishService.getDishDetail(id)), HttpStatus.OK);
    }

    @GetMapping("/planning")
    public ResponseEntity<PlanningDataRequestByCategory> getDishesByCategory() {
        return new ResponseEntity<>(new PlanningDataRequestByCategory(dishService.getPlanningData()), HttpStatus.OK);
    }
}
