package com.example.be.domain;

import java.math.BigDecimal;

public class Dish {
    private Long dish_id;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private Badge badge;
    private DeliveryType deliveryType;
    private String thumbnail;
    private DishStatus dishStatus;
    private Long categoryId;
}
