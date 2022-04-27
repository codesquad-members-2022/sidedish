package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SideDishDetailsDto {

    private Integer id;
    private String name;
    private boolean dawnDeliveryFlag;
    private boolean wholeNationDeliveryFlag;
    private Integer price;
    private String discountType;
    private Integer discountRate;
    private List<String> imageFiles;
    private List<SideDishDto> recommendedSideDishes;

    public SideDishDetailsDto(Integer id, String name, boolean dawnDeliveryFlag,
        boolean wholeNationDeliveryFlag, Integer price, String discountType,
        Integer discountRate, List<String> imageFiles,
        List<SideDishDto> recommendedSideDishes) {
        this.id = id;
        this.name = name;
        this.dawnDeliveryFlag = dawnDeliveryFlag;
        this.wholeNationDeliveryFlag = wholeNationDeliveryFlag;
        this.price = price;
        this.discountType = discountType;
        this.discountRate = discountRate;
        this.imageFiles = imageFiles;
        this.recommendedSideDishes = recommendedSideDishes;
    }
}
