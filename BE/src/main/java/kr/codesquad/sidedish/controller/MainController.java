package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService categoryService;

    public MainController(MainService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Map<Long, List<DishSimpleResponse>>> showMain() {
        return ResponseEntity.ok(categoryService.getAllDishes());
    }

}
