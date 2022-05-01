package com.sidedish.dto;

import lombok.Getter;

@Getter
public class SideDishDto {

    private final Integer id;
    private final String name;
    private final String description;
    private final boolean dawnDeliveryFlag;
    private final boolean wholeNationDeliveryFlag;
    private final Integer price;
    private final String discountType;
    private final Integer discountRate;
    private final String saveFileName;

    public SideDishDto(Integer id, String name, String description, boolean dawnDeliveryFlag,
        boolean wholeNationDeliveryFlag, Integer price, String discountType,
        Integer discountRate, String saveFileName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dawnDeliveryFlag = dawnDeliveryFlag;
        this.wholeNationDeliveryFlag = wholeNationDeliveryFlag;
        this.price = price;
        this.discountType = discountType;
        this.discountRate = discountRate;
        this.saveFileName = saveFileName;
    }
}
