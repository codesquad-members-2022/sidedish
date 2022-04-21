package com.codesquad.sidedish.item.dto;

import com.codesquad.sidedish.item.domain.Item;

public class ItemDto {
    private Integer id;
    private String discountPoilcy;
    private Integer discountRate;
    private String description;
    private String name;
    private Integer price;
    private String mainImageLink;

    public ItemDto(Integer id, String discountPoilcy, Integer discountRate, String description, String name, Integer price, String mainImageLink) {
        this.id = id;
        this.discountPoilcy = discountPoilcy;
        this.discountRate = discountRate;
        this.description = description;
        this.name = name;
        this.price = price;
        this.mainImageLink = mainImageLink;
    }

    public static ItemDto from(Item item) {
        return new ItemDto(item.getId(), item.getDiscountPolicy(), item.getDiscountRate(), item.getDescription(), item.getName(), item.getPrice(), item.getMainImageLink());
    }

    public Integer getId() {
        return id;
    }

    public String getDiscountPoilcy() {
        return discountPoilcy;
    }

    public Integer getDiscountRate() {
        return discountRate;
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
