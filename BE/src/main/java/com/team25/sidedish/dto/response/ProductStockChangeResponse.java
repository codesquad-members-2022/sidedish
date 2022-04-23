package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductStockChangeResponse {

    private Long id;
    private int remainStock;

    public static ProductStockChangeResponse from(Product product) {
        ProductStockChangeResponse response = new ProductStockChangeResponse();
        response.id = product.getId();
        response.remainStock = product.getStock();
        return response;
    }
}
