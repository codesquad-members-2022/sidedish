package com.team34.sidedish.dto;

import java.util.List;

public class DishesResponse {

    private List<DishResponse> eventItems;
    private List<DishResponse> items;

    public DishesResponse(List<DishResponse> eventItems, List<DishResponse> items) {
        this.eventItems = eventItems;
        this.items = items;
    }

    public List<DishResponse> getEventItems() {
        return eventItems;
    }

    public List<DishResponse> getItems() {
        return items;
    }
}
