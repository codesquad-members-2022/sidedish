package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Category;
import team31.codesuqad.sidedish.domain.Dish;
import team31.codesuqad.sidedish.domain.Event;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryResponse {

    private final Integer eventTabsId;
    private final String eventTabsName;
    private List<DishDto> dishes;

    public CategoryResponse(Event event, List<Dish> dishes) {
        this.eventTabsId = event.getId();
        this.eventTabsName = event.getDescription();
        this.dishes = makeDishDtos(dishes);
    }

    public CategoryResponse(Category category, List<Dish> dishes) {
        this.eventTabsId = category.getId();
        this.eventTabsName = category.getName();
        this.dishes = makeDishDtos(dishes);
    }

    private List<DishDto> makeDishDtos(List<Dish> dishes) {
        return dishes.stream()
                .map(DishDto::new)
                .collect(Collectors.toList());
    }

    public Integer getEventTabsId() {
        return eventTabsId;
    }

    public String getEventTabsName() {
        return eventTabsName;
    }

    public List<DishDto> getDishes() {
        return dishes;
    }

}
