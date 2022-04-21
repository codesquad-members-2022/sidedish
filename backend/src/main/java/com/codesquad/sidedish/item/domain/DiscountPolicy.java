package com.codesquad.sidedish.item.domain;

public class DiscountPolicy {
    private Integer id;
    private String name;
    private String type;
    private Integer value;

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
