package kr.codesquad.sidedish.dto;


import kr.codesquad.sidedish.domain.DiscountPolicy;
import kr.codesquad.sidedish.domain.Dish;

import java.util.List;

public class DishDetailResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final List<String> images;
    private final int stock;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public DishDetailResponse(Long id, String name, String description, List<String> images,
                              int stock, int price, DiscountPolicy discountPolicy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.stock = stock;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
    public static DishDetailResponse of(Dish dish, List<String> images) {
        return new DishDetailResponse(dish.getId(), dish.getName(), dish.getDescription(), images,
                dish.getStock(), dish.getPrice(), dish.getDiscountPolicy());
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

    public List<String> getImages() {
        return images;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
