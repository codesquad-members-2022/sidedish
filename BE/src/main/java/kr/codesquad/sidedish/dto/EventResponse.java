package kr.codesquad.sidedish.dto;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Event;

import java.util.List;
import java.util.stream.Collectors;

public class EventResponse {

    private Long id;
    private String name;
    private String description;
    private List<DishSimpleResponse> dishes;

    public EventResponse(Long id, String name, String description, List<DishSimpleResponse> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dishes = dishes;
    }

    public static EventResponse from(Event event) {
        List<DishSimpleResponse> dishSimpleResponses = event.getDishes().stream().map(DishSimpleResponse::of).collect(Collectors.toList());
        return new EventResponse(event.getId(), event.getName(), event.getDescription(), dishSimpleResponses);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<DishSimpleResponse> getDishes() {
        return dishes;
    }
}
