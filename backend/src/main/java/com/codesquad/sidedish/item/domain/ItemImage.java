package com.codesquad.sidedish.item.domain;

import io.swagger.v3.oas.annotations.media.Schema;

public class ItemImage {
    private String imageLink;

    public ItemImage(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
    }
}
