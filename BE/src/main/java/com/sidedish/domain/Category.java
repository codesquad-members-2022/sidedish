package com.sidedish.domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Category {

    @Id
    private Long id; // 1L
    private CategoryType type;

    public Category(CategoryType type) {
        this.type = type;
    }

    private List<Item> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public CategoryType getType() {
        return type;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void saveItem(Item item) {
        items.add(item);
    }
}
