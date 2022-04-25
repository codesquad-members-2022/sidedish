package kr.codesquad.sidedish.dto;

import kr.codesquad.sidedish.domain.DeliveryType;
import kr.codesquad.sidedish.domain.DiscountPolicy;
import kr.codesquad.sidedish.domain.Dish;

import java.util.Objects;

public class DishSimpleResponse {

    private static final int MAIN_IMAGE_INDEX = 0;

    private final Long id;
    private final String name;
    private final String description;
    private final String image;
    private final int stock;
    private final int normalPrice;
    private final int discountPrice;
    private final DeliveryType deliveryType;
    private final DiscountPolicy discountPolicy;

    public DishSimpleResponse(Long id, String name, String description, String image, int stock,
                              int normalPrice, int discountPrice, DeliveryType deliveryType,
                              DiscountPolicy discountPolicy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.stock = stock;
        this.normalPrice = normalPrice;
        this.discountPrice = discountPrice;
        this.deliveryType = deliveryType;
        this.discountPolicy = discountPolicy;
    }

    public static DishSimpleResponse of(Dish dish) {
        return new DishSimpleResponse(dish.getId(), dish.getName(), dish.getDescription(),
                dish.getImageName(MAIN_IMAGE_INDEX), dish.getStock(), dish.getPrice(), dish.getDiscountPrice(),
                dish.getDeliveryType(), dish.getDiscountPolicy());
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getStock() {
        return stock;
    }

    public int getNormalPrice() {
        return normalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishSimpleResponse that = (DishSimpleResponse) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
