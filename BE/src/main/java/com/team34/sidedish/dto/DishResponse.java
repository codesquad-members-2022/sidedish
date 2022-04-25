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
    private List<String> badges;
    private List<String> categories;

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

    public List<String> getBadges() {
        return badges;
    }

    public List<String> getCategories() {
        return categories;
    }
}
