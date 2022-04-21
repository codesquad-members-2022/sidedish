package com.team28.sidedish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductImageResponse {

    private Long imageId;
    private String imageURL;
    private boolean representYn;
    private int sequence;
}
