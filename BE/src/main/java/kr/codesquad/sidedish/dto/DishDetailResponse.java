package kr.codesquad.sidedish.dto;


import kr.codesquad.sidedish.domain.DeliveryType;
import kr.codesquad.sidedish.domain.DiscountPolicy;
import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.domain.Image;

import java.util.List;

public class DishDetailResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final int normalPrice;
    private final int discountPrice;
    private final int stock;
    private final int point;
    private final DiscountPolicy discountPolicy;
    private final DeliveryType deliveryType;
    private final List<Image> images;


    public DishDetailResponse(Long id, String name, String description, int normalPrice,
        int discountPrice, int stock, int point,
        DiscountPolicy discountPolicy, DeliveryType deliveryType, List<Image> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.point = point;
        this.discountPolicy = discountPolicy;
        this.deliveryType = deliveryType;
        this.images = images;
    }

    public static DishDetailResponse from(Dish dish) {
        return new DishDetailResponse(dish.getId(), dish.getName(), dish.getDescription(),
            dish.getPrice(),
            dish.getDiscountPrice(), dish.getStock(), dish.getPoint(), dish.getDiscountPolicy(),
            dish.getDeliveryType(), dish.getImages());
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

    public int getNormalPrice() {
        return normalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public List<Image> getImages() {
        return images;
    }

    public int getPoint() {
        return point;
    }

    public int getStock() {
        return stock;
    }
}
