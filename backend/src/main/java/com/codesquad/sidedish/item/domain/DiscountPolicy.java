package com.codesquad.sidedish.item.domain;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class DiscountPolicy {
    @Id
    private Integer id;
    private String name;
    private String type;
    private Integer value;
    private Set<Item> items = new HashSet<>();

    public DiscountPolicy(Integer id, String name, String type, Integer value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }
}
