package com.codesquad.sidedish.item.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Category {
    @Id
    private final Integer id;
    private final String name;
    @MappedCollection(idColumn = "CATEGORY_ID")
    private Set<Item> items = new HashSet<>();

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getItems() {
        return items;
    }
}
