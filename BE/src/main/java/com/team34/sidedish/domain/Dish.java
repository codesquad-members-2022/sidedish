package com.team34.sidedish.domain;

import java.util.List;

public class Dish {

    private Long id;
    private String title;
    private String content;
    private int price;
    private int stock;
    private int deliveryFee;
    private Integer freeShippingAmount;
    private double mileage_ratio;
    private boolean earlyDeliverable;
    private List<Category> categories;
    private List<DishImage> images;
}
