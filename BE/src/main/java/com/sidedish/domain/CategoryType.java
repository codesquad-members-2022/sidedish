package com.sidedish.domain;

public enum CategoryType {
    MAIN(1L), SOUP(2L), SIDE(3L);

    private Long typeNumber;

    CategoryType(Long typeNumber) {
        this.typeNumber = typeNumber;
    }

    public Long getTypeNumber() {
        return typeNumber;
    }
}
