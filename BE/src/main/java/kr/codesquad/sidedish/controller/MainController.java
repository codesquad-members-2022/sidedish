package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

//    @GetMapping
//    public ResponseEntity<Map<Long, List<DishSimpleResponse>>> showMain() {
//        return ResponseEntity.ok(categoryService.getAllDishes());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorizedDishes> findCategorizedById(@PathVariable Long id) {
        CategorizedDishes categorizedDishes = mainService.find(id);

        return ResponseEntity.ok(categorizedDishes);
    }

}
