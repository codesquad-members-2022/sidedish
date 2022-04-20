package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService categoryService;

    public MainController(MainService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public ResponseEntity<Map<Long, List<DishSimpleResponse>>> showMain() {
//        return ResponseEntity.ok(categoryService.getAllDishes());
//    }

}
