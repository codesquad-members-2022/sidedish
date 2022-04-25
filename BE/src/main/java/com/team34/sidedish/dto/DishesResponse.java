package com.team34.sidedish.dto;

import java.util.List;

public class DishesResponse {

    private List<DishesResponse> eventItems;
    private List<DishesResponse> items;

    public List<DishesResponse> getEventItems() {
        return eventItems;
    }

    public List<DishesResponse> getItems() {
        return items;
    }
}
