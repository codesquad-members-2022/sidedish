package com.codesquad.sidedish.item.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class ItemImage {
    private Integer id;
    @Schema(description = "상세 이미지 링크", example = "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg")
    private String imageLink;

    public ItemImage(Integer id, String imageLink) {
        this.id = id;
        this.imageLink = imageLink;
    }

    public Integer getId() {
        return id;
    }

    public String getImageLink() {
        return imageLink;
    }
}
