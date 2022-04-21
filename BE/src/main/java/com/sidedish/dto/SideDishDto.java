package com.sidedish.dto;

import lombok.Getter;

@Getter
public class SideDishDto {

    private Long id;
    private String name;
    private String description;
    private boolean dawnDeliveryFlag;
    private boolean wholeNationDeliveryFlag;
    private Integer price;
    private String discountType;
    private Integer discountRate;
    private String saveFileName;

    public SideDishDto(Long id, String name, String description, boolean dawnDeliveryFlag,
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
