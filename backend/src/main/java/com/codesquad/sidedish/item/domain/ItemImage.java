package com.codesquad.sidedish.item.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class ItemImage {
    @Schema(description = "상세 이미지 링크", example = "https://leejohy-springboot-build.s3.ap-northeast-2.amazonaws.com/2cdf7235b65a114abff05b9133f90085.jpeg")
    private String imageLink;

    public ItemImage(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }
}
