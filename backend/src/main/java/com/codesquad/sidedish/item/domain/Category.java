package com.codesquad.sidedish.item.domain;

public enum Category {
    MAIN("모두가 좋아하는 든든한 메인요리"),
    SOUP("정성이 담긴 뜨끈한 국물요리"),
    SIDE("식탁을 풍성하게 하는 정갈한 밑반찬");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
