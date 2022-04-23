package com.codesquad.sidedish.item.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("ITEM_IMAGE")
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
