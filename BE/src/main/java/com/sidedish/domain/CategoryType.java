package com.sidedish.domain;

public enum CategoryType {
    MAIN("main"), SIDE("side"), SOUP("side");

    private String name;

    CategoryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
