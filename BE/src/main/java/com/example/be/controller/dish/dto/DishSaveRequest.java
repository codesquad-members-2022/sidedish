package com.example.be.controller.dish.dto;

import com.example.be.domain.dish.Badge;
import com.example.be.domain.dish.DeliveryPriceOption;
import com.example.be.domain.dish.Dish;
import com.example.be.domain.dish.DishStatus;
import com.example.be.domain.image.Image;

import java.math.BigDecimal;
import java.util.List;

public class DishSaveRequest {
    private String name;
    private String description;
    private BigDecimal normalPrice;
    private BigDecimal salePrice;
    private Badge badge;
    private DeliveryPriceOption deliveryPriceOption;
    private String thumbnail;
    private DishStatus dishStatus;
    private int count;
    private Long categoryId;
    private List<Image> images;

    public DishSaveRequest(String name, String description, BigDecimal normalPrice, BigDecimal salePrice, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus, int count, Long categoryId, List<Image> images) {
        this.name = name;
        this.description = description;
        this.normalPrice = normalPrice;
        this.salePrice = salePrice;
        this.badge = badge;
        this.deliveryPriceOption = deliveryPriceOption;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.count = count;
        this.categoryId = categoryId;
        this.images = images;
    }

    public Dish toEntity() {
        return new Dish(name, description, normalPrice, badge, deliveryPriceOption, thumbnail, dishStatus, count, images);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public Badge getBadge() {
        return badge;
    }

    public DeliveryPriceOption getDeliveryPriceOption() {
        return deliveryPriceOption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public int getCount() {
        return count;
    }

    public List<Image> getImages() {
        return images;
    }
}
