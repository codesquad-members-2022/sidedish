package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendDto {

    private List<DishDto> dishes;
    private final Integer totalPages;

    public RecommendDto(List<Dish> dishes, Integer totalPages) {
        this.dishes = makeDishDtos(dishes);
        this.totalPages = totalPages;
    }

    private List<DishDto> makeDishDtos(List<Dish> dishes) {
        return dishes.stream()
                .map(DishDto::new)
                .collect(Collectors.toList());
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

}
