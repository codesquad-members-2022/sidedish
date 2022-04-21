package com.example.be.controller.dish;

import static com.example.be.controller.ApiResult.OK;

import com.example.be.controller.ApiResult;
import com.example.be.controller.dish.dto.PlanningDataRequest;
import com.example.be.service.dish.DishService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
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
    public ApiResult<DishDetail> getDishDetail(@PathVariable("id") Long id) {
        return OK(new DishDetail(dishService.getDishDetail(id)));
    }

    @GetMapping("/test")
    public ApiResult<PlanningDataRequestByCategory> getDishesByCategory() {
        return OK(new PlanningDataRequestByCategory(dishService.getPlanningData()));
    }
}
