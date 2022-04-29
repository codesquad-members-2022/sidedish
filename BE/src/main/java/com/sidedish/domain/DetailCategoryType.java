package com.sidedish.domain;

public enum DetailCategoryType {
    MEAT("풍성한_고기_반찬"),
    NUTRITION("우리_아이_영양_반찬"),
    CONVENIENT("편리한_반찬_세트"),
    SEASONAL("맛있는_제철_요리"),
    HOTSOUP("정성이_담긴_뜨끈뜨끈한_국물_요리");

    private final String detailType;

    DetailCategoryType(String detailType) {
        this.detailType = detailType;
    }

    public String getDetailType() {
        return detailType;
    }
}
