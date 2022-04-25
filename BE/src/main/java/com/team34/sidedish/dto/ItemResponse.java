package com.team34.sidedish.dto;

import java.util.List;

public class ItemResponse {

    private Long id;
    private int originPrice;
    private int discountPrice;
    private boolean earlyDeliverable;
    private String mainImagePath;
    private String title;
    private String content;
    private List<String> badges;
    private List<String> categories;
}
