package com.team34.sidedish.dto;

import java.util.List;

public class DishDetailResponse {

    private int originPrice;
    private int discountPrice;
    private int deliveryFee;
    private double mileageRatio;
    private boolean earlyDeliverable;
    private Integer freeShippingAmount;
    private String title;
    private String content;
    private List<String> images;
    private List<String> badges;
    private List<DishResponse> recommendedItems;

    public int getOriginPrice() {
        return originPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public double getMileageRatio() {
        return mileageRatio;
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

    public List<String> getBadges() {
        return badges;
    }

    public List<DishResponse> getRecommendedItems() {
        return recommendedItems;
    }
}
