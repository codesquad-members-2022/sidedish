package kr.codesquad.sidedish.dto;

import kr.codesquad.sidedish.domain.MainCategory;
import kr.codesquad.sidedish.domain.Dish;

import java.util.List;

public class CategorizedDishes {

    private final MainCategory mainCategory;
    private final List<Dish> dishes;


    public CategorizedDishes(MainCategory mainCategory, List<Dish> dishes) {
        this.mainCategory = mainCategory;
        this.dishes = dishes;
    }

    public MainCategory getMainCategory() {
        return mainCategory;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
