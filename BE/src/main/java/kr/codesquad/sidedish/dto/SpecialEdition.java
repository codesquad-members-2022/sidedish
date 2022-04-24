package kr.codesquad.sidedish.dto;

import java.util.List;
import kr.codesquad.sidedish.domain.Event;

public class SpecialEdition {

    private final String name = "기획전";
    private List<Event> eventDishes;

    public SpecialEdition(List<Event> eventDishes) {
        this.eventDishes = eventDishes;
    }

    public String getName() {
        return name;
    }

    public List<Event> getEventDishes() {
        return eventDishes;
    }
}
