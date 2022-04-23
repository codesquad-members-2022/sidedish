package com.codesquad.sidedish.item.dto;

import java.util.Set;

import com.codesquad.sidedish.item.domain.ItemImage;

public class DetailItemDto {
    private Integer id;
    private String discountPolicy;
    private Integer discountRate;
    private String description;
    private String name;
    private Integer price;
    private String mainImageLink;
    private Set<ItemImage> detailImageLink;

    public DetailItemDto(Integer id, String discountPolicy, Integer discountRate, String description, String name, Integer price, String mainImageLink, Set<ItemImage> detailImageLink) {
        this.id = id;
        this.discountPolicy = discountPolicy;
        this.discountRate = discountRate;
        this.description = description;
        this.name = name;
        this.price = price;
        this.mainImageLink = mainImageLink;
        this.detailImageLink = detailImageLink;
    }

    public Integer getId() {
        return id;
    }

    public String getDiscountPolicy() {
        return discountPolicy;
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

    public Set<ItemImage> getDetailImageLink() {
        return detailImageLink;
    }
}
