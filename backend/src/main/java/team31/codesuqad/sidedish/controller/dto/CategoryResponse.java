package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Category;
import team31.codesuqad.sidedish.domain.EventTabs;

import java.util.List;

public class CategoryResponse {

    private Integer eventTabsId;
    private String eventTabsName;
    private List<DishDto> dishes;

    public CategoryResponse(EventTabs eventTabs, List<DishDto> dishes) {
        this.eventTabsId = eventTabs.getId();
        this.eventTabsName = eventTabs.getDescription();
        this.dishes = dishes;
    }

    public CategoryResponse(Category category, List<DishDto> dishes) {
        this.eventTabsId = category.getId();
        this.eventTabsName = category.getName();
        this.dishes = dishes;
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
