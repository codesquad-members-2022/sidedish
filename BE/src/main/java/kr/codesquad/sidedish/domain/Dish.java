package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Dish {

    @Id
    private final Long id;
    private final Long categoryId;
    private final String name;
    private final String description;
    private final int stock;
    private final int price;
    private final DeliveryType deliveryType;
    private final DiscountPolicy discountPolicy;

    public Dish(Long id, Long categoryId, String name, String description,
                int stock, int price, DeliveryType deliveryType, DiscountPolicy discountPolicy) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.deliveryType = deliveryType;
        this.discountPolicy = discountPolicy;
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
