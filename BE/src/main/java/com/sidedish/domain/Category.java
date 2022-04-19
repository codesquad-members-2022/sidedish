package com.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Category {

    @Id
    private Long id; // 1L
    private CategoryType type;

    public Category(CategoryType type) {
        this.type = type;
    }

    @MappedCollection(idColumn = "category_id", keyColumn = "id")
    private Map<String, Item> items = new ConcurrentHashMap<>();

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public void saveItem(Item item) {
        items.put(item.getId(), item);
    }
}
