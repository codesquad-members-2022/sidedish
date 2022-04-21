package com.codesquad.sidedish.item.dto;

import com.codesquad.sidedish.item.domain.DiscountPolicy;
import com.codesquad.sidedish.item.domain.Item;

public class ItemDto {
    private Integer itemId;
    private String discountPoilcy;
    private String description;
    private String name;
    private Integer price;
    private String mainImageLink;

    private ItemDto(Integer itemId, String discountPoilcy, String description, String name, Integer price, String mainImageLink) {
        this.itemId = itemId;
        this.discountPoilcy = discountPoilcy;
        this.description = description;
        this.name = name;
        this.price = price;
        this.mainImageLink = mainImageLink;
    }

    public static ItemDto from(Item item, DiscountPolicy discountPolicy) {
        return new ItemDto(item.getId(), discountPolicy.getName(), item.getDescription(), item.getName(), item.getPrice(), item.getMainImageLink());
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

    public Integer getPrice() {
        return price;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }
}
