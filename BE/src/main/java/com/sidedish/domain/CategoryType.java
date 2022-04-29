package com.sidedish.domain;

public enum CategoryType {
    MAIN("모두가 좋아하는 든든한 메인요리"), SOUP("정성이 담긴 뜨끈뜨끈 국물 요리"), SIDE("식탁을 풍성하게 하는 정갈한 밑반찬");

    private final String title;
    CategoryType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
