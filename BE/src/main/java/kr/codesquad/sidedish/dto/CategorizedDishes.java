package kr.codesquad.sidedish.dto;

import kr.codesquad.sidedish.domain.Category;


import java.util.List;

public class CategorizedDishes {

    private final Category category;
    private final List<DishSimpleResponse> dishes;


    public CategorizedDishes(Category mainCategory, List<DishSimpleResponse> dishes) {
        this.category = mainCategory;
        this.dishes = dishes;
    }

    public Category getCategory() {
        return category;
    }

    public List<DishSimpleResponse> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "CategorizedDishes{" +
            "category=" + category +
            ", dishes=" + dishes +
            '}';
    }
}
