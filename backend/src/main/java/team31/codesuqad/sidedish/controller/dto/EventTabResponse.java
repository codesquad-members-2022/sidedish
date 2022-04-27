package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.EventTabs;

import java.util.List;

public class EventTabResponse {

    private Integer eventTabsId;
    private String eventTabsName;
    private List<DishDto> dishes;

    public EventTabResponse(EventTabs eventTabs, List<DishDto> dishes) {
        this.eventTabsId = eventTabs.getId();
        this.eventTabsName = eventTabs.getDescription();
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
