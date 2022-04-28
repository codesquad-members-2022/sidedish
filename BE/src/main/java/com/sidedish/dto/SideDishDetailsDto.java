package com.sidedish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SideDishDetailsDto {

    private final Integer id;
    private final String name;
    private final boolean dawnDeliveryFlag;
    private final boolean wholeNationDeliveryFlag;
    private final Integer price;
    private final String discountType;
    private final Integer discountRate;
    private final List<String> imageFiles;
    private final List<SideDishDto> recommendedSideDishes;

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
