package com.example.be.controller.dish;

import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.service.dish.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<PlanningDataRequest> getPlanningData() {
        return dishService.getPlanningData();
    }

//    @GetMapping
//    public ApiResult<List<PlanningDataRequest>> getPlanningData() {
//        return OK(dishService.getPlanningData());
//    }

    @GetMapping("{id}")
    public ResponseEntity<DishDetail> getDishDetail(@PathVariable("id") Long id) {
        return new ResponseEntity<>(new DishDetail(dishService.getDishDetail(id)), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<PlanningDataRequestByCategory> getDishesByCategory() {
        return new ResponseEntity<>(new PlanningDataRequestByCategory(dishService.getPlanningData()), HttpStatus.OK);
    }
}
