package kr.codesquad.sidedish.dto;

import java.util.List;

import kr.codesquad.sidedish.domain.Event;

public class SpecialEdition {

    private final String name = "짱민BEST 추천 메뉴";
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
