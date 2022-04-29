package com.example.be.business.dish.controller;

import com.example.be.business.dish.controller.dto.DishDetailResponse;
import com.example.be.business.dish.controller.dto.PlanningDataRequestByCategory;
import com.example.be.business.category.repository.CategoryRepository;
import com.example.be.business.dish.service.DishService;
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

    @PostMapping("{id}/update")
    public ResponseEntity<PlanningDataRequestByCategory> updateDish(@PathVariable("id") Long id, @RequestBody DishUpdateRequest dishUpdateRequest) {
        dishService.updateDish(id, dishUpdateRequest.getPrice(), dishUpdateRequest.getBadge(), dishUpdateRequest.getDeliveryPriceOption(),
                dishUpdateRequest.getThumbnail(), dishUpdateRequest.getDishStatus(), dishUpdateRequest.getCategoryId(), dishUpdateRequest.getCount());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
