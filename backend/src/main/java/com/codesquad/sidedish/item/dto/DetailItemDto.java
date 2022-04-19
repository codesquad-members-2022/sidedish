package com.codesquad.sidedish.item.dto;

public class DetailItemDto {

    private Integer itemId;
    private String name;
    private String description;
    private Integer price;
    private String mainImageLink;
    private String detailImageLink;

    public DetailItemDto(Integer itemId, String name, String description, Integer price, String mainImageLink, String detailImageLink) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.mainImageLink = mainImageLink;
        this.detailImageLink = detailImageLink;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public String getDetailImageLink() {
        return detailImageLink;
    }
}
