package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "상품 주문 응답")
@Getter
@NoArgsConstructor
public class ProductStockChangeResponse {

    @Schema(description = "상품 아이디")
    private Long id;
    @Schema(description = "상품 재고 수량")
    private int remainStock;

    public static ProductStockChangeResponse from(Product product) {
        ProductStockChangeResponse response = new ProductStockChangeResponse();
        response.id = product.getId();
        response.remainStock = product.getStock();
        return response;
    }
}
