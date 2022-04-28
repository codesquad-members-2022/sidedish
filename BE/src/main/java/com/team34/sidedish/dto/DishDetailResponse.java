package com.team34.sidedish.dto;

import com.team34.sidedish.domain.Badge;
import com.team34.sidedish.domain.Dish;
import java.util.List;
import java.util.stream.Collectors;

public class DishDetailResponse {

    private int originPrice;
    private int discountPrice;
    private int deliveryFee;
    private double mileageRate;
    private boolean earlyDeliverable;
    private Integer freeShippingAmount;
    private String title;
    private String content;
    private List<String> images;
    private String badge;
    private List<DishResponse> recommendedItems;

    public DishDetailResponse(Dish dish, List<Dish> recommendedDishes) {
        this.originPrice = dish.getPrice();
        this.discountPrice = Badge.calculateDiscountPrice(dish.getPrice(), dish.getTag());
        this.deliveryFee = dish.getDeliveryFee();
        this.mileageRate = dish.getMileageRate();
        this.earlyDeliverable = dish.isEarlyDeliverable();
        this.title = dish.getTitle();
        this.content = dish.getContent();
        this.images = dish.getImagePaths();
        this.badge = dish.getTag();
        this.recommendedItems = recommendedDishes.stream().map(DishResponse::new).collect(
            Collectors.toList());
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public double getMileageRate() {
        return mileageRate;
    }

    public boolean isEarlyDeliverable() {
        return earlyDeliverable;
    }

    public Integer getFreeShippingAmount() {
        return freeShippingAmount;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getImages() {
        return images;
    }

    public String getBadge() {
        return badge;
    }

    public List<DishResponse> getRecommendedItems() {
        return recommendedItems;
    }
}
