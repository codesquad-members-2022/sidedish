package com.terria.sidedish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SideDishCardResponse {

    private long sideDishId;
    private String imageUrl;
    private String name;
    private String description;
    private int disCountPrice;
    private int price;
    private String shippingInfo;
    private List<SideDishCard.EventResponse> discountEvents;
}
