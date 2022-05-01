package com.sidedish.dto;

import lombok.Getter;

@Getter
public class SideDishOrderDto {

    private Integer sidedishId;
    private Integer totalPrice;
    private Integer fee;
    private Integer quantity;
    private Integer point;
}
