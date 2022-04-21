package com.team28.sidedish.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Schema(description = "주문 생성 요청")
@Getter
@AllArgsConstructor
public class OrderRequest {

    @Schema(description = "상품 아이디")
    private Long productId;

    @Schema(description = "회원 아이디")
    private String userId;

    @Schema(description = "상품 수량")
    private int quantity;

    @Schema(description = "가격")
    private int price;
}
