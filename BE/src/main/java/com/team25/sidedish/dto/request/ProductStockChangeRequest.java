package com.team25.sidedish.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "상품 주문 요청")
@Getter
@NoArgsConstructor
public class ProductStockChangeRequest {

    @Schema(description = "상품 아이디")
    @NotNull(message = "주문 요청 상품 아이디는 null일 수 없습니다")
    private Long id;

    @Schema(description = "상품 주문 수량")
    @Positive(message = "주문 수량은 양수여야 합니다")
    @NotNull(message = "주문 수량을 null일 수 없습니다")
    private int amount;

    public ProductStockChangeRequest(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
