package com.codesquad.sidedish.item.dto;

public class DetailItemDto {
    private Integer id;
    private String discountPolicy;
    private Integer discountRate;
    private String description;
    private String name;
    private Integer price;
    private String mainImageLink;
    private String detailImageLink;

    public DetailItemDto(Integer id, String discountPolicy, Integer discountRate, String description, String name, Integer price, String mainImageLink, String detailImageLink) {
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

    public String getDetailImageLink() {
        return detailImageLink;
    }
}
