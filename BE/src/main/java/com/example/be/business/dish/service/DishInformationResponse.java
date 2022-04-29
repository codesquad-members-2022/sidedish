package com.example.be.business.dish.service;


import com.example.be.business.dish.domain.Badge;

import java.math.BigDecimal;
import java.util.Objects;

public class DishInformationResponse {
    private Long dishId;
    private String name;
    private String description;
    private Long categoryId;
    private BigDecimal price;
    private Badge badge;
    private String thumbnail;
    private String categoryDescription;
    private String descriptionDetail;
    private CategoryType categoryType;

    public DishInformationResponse(Long dishId, String name, String description, Long categoryId, BigDecimal price, Badge badge, String thumbnail, String categoryDescription, String descriptionDetail, CategoryType categoryType) {
        this.dishId = dishId;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.price = price;
        this.badge = badge;
        this.thumbnail = thumbnail;
        this.categoryDescription = categoryDescription;
        this.descriptionDetail = descriptionDetail;
        this.categoryType = categoryType;
    }

    public Long getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Badge getBadge() {
        return badge;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public boolean equalTo(Long categoryId){
        return Objects.equals(this.categoryId, categoryId);
    }
}
