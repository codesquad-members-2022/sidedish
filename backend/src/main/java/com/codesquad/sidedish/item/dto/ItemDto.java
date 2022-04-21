package com.codesquad.sidedish.item.dto;

public class ItemDto {
    private Integer itemId;
    private String discountPoilcy;
    private String description;
    private String name;
    private String price;
    private String mainImageLink;

    public ItemDto(Integer itemId, String discountPoilcy, String description, String name, String price, String mainImageLink) {
        this.itemId = itemId;
        this.discountPoilcy = discountPoilcy;
        this.description = description;
        this.name = name;
        this.price = price;
        this.mainImageLink = mainImageLink;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getDiscountPoilcy() {
        return discountPoilcy;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }
}
