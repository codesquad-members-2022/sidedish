package com.team25.sidedish.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "상품 주문 요청")
@Getter
@NoArgsConstructor
public class ProductStockChangeRequest {

    @Schema(description = "상품 아이디")
    private Long id;
    @Schema(description = "상품 주문 수량")
    private int amount;

    public ProductStockChangeRequest(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
