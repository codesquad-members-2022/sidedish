package kr.codesquad.sidedish.dto;

import java.util.List;
import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Event;

public class EventDishes {

    private String specialEdition;
    private Event event;
    private List<Dish> dishes;

    public EventDishes(String specialEdition, Event event,
        List<Dish> dishes) {
        this.specialEdition = specialEdition;
        this.event = event;
        this.dishes = dishes;
    }

    public String getSpecialEdition() {
        return specialEdition;
    }

    public Event getEvent() {
        return event;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
