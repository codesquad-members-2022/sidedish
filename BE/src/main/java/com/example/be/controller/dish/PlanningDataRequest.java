package com.example.be.controller.dish;

import com.example.be.domain.Badge;
import com.example.be.domain.DeliveryType;
import com.example.be.domain.DishStatus;

import java.math.BigDecimal;

public class PlanningDataRequest {
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private Badge badge;
    private DeliveryType deliveryType;
    private String thumbnail;
    private DishStatus dishStatus;
    private Long categoryId;
    private String title;
}
