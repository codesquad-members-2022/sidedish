package com.team34.sidedish.dto;

import java.util.List;

public class DishResponse {

    private Long id;
    private int originPrice;
    private int discountPrice;
    private boolean earlyDeliverable;
    private String mainImagePath;
    private String title;
    private String content;
    private String badge;
    private List<Long> categories;

    public DishResponse(Long id, int originPrice, int discountPrice, boolean earlyDeliverable,
        String mainImagePath, String title, String content, String badge,
        List<Long> categories) {
        this.id = id;
        this.originPrice = originPrice;
        this.discountPrice = discountPrice;
        this.earlyDeliverable = earlyDeliverable;
        this.mainImagePath = mainImagePath;
        this.title = title;
        this.content = content;
        this.badge = badge;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public boolean isEarlyDeliverable() {
        return earlyDeliverable;
    }

    public String getMainImagePath() {
        return mainImagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getBadge() {
        return badge;
    }

    public List<Long> getCategories() {
        return categories;
    }
}
