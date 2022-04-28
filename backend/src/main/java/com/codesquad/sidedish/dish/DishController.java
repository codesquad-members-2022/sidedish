package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.dto.DishListResponse;
import com.codesquad.sidedish.dish.dto.DishUnitResponse;
import com.codesquad.sidedish.other.page.Criteria;
import com.codesquad.sidedish.other.page.Slice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @GetMapping
    public Slice<DishListResponse> findDishes(
        @RequestParam(value = "section", required = false) String sectionName,
        @RequestParam(value = "category", required = false) String categoryName,
        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
        @RequestParam(value = "size", required = false, defaultValue = "4") int size
    ) {
        Criteria criteria = new Criteria(page, size);
        if (sectionName != null) {
            return dishService.findDishesBySection(sectionName.replace("-", " "), criteria);
        }
        if (categoryName != null) {
            return dishService.findDishesByCategory(categoryName.replace("-", " "), criteria);
        }
        return new Slice<>();
    }

    @GetMapping("/{id}")
    public DishUnitResponse findDish(@PathVariable("id") Integer dishId) {
        return dishService.findDish(dishId);
    }

    @GetMapping("/{id}/recommend")
    public Slice<DishListResponse> findRecommendDishes(
        @PathVariable("id") Integer dishId,
        @RequestParam(value = "page", required = false, defaultValue = "1") int page,
        @RequestParam(value = "size", required = false, defaultValue = "5") int size) {
        Criteria criteria = new Criteria(page, size);
        return dishService.findRecommendDishes(dishId, criteria);
    }
}
