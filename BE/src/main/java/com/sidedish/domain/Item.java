package com.sidedish.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table(value = "items")
public class Item {

    @Id
    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private double discountRate;
    private Badge badge;
    private String detailType;
    private int quantity;
    private BigDecimal rewardPoint;
    private String image;

    @Column(value = "category_id")
    private Long categoryId;

    public Item(String title, String description, BigDecimal price, double discountRate, Badge badge, String detailType, int quantity, BigDecimal rewardPoint, String image) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountRate = discountRate;
        this.badge = badge;
        this.detailType = detailType;
        this.quantity = quantity;
        this.rewardPoint = rewardPoint;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
