package com.codesquad.sidedish.item.domain;

public class ItemImage {
    private Integer id;
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
