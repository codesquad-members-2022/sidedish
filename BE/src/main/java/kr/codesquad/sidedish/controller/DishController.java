package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.DishDetailResponse;
import kr.codesquad.sidedish.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishDetailResponse> showOne(@PathVariable Long id) {

        DishDetailResponse one = dishService.findOne(id);

        return ResponseEntity.ok(one);
    }
}
