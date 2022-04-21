package com.codesquad.sidedish.item.dto;

public class DetailItemDto {
    private Integer itemId;
    private String discountPolicy;
    private String description;
    private String name;
    private Integer price;
    private String mainImageLink;
    private String detailImageLink;

    public DetailItemDto(Integer itemId, String discountPolicy, String description, String name, Integer price, String mainImageLink, String detailImageLink) {
        this.itemId = itemId;
        this.discountPolicy = discountPolicy;
        this.description = description;
        this.name = name;
        this.price = price;
        this.mainImageLink = mainImageLink;
        this.detailImageLink = detailImageLink;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getDiscountPolicy() {
        return discountPolicy;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
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
