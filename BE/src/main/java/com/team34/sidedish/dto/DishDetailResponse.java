package com.team34.sidedish.dto;

import java.util.List;

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

    public DishDetailResponse(int originPrice, int discountPrice, int deliveryFee,
        double mileageRate,
        boolean earlyDeliverable, Integer freeShippingAmount, String title, String content,
        List<String> images, String badge,
        List<DishResponse> recommendedItems) {
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
        this.deliveryFee = deliveryFee;
        this.mileageRate = mileageRate;
        this.earlyDeliverable = earlyDeliverable;
        this.freeShippingAmount = freeShippingAmount;
        this.title = title;
        this.content = content;
        this.images = images;
        this.badge = badge;
        this.recommendedItems = recommendedItems;
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
