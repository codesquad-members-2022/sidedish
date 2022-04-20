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
 }
