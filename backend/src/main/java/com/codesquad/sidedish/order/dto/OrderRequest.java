package com.codesquad.sidedish.order.dto;

import lombok.Getter;

@Getter
public class OrderRequest {

    private String githubId;
    private Integer dishId;
    private Integer quantity;

}
