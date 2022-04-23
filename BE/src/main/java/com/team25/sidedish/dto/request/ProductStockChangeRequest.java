package com.team25.sidedish.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductStockChangeRequest {

    private Long id;
    private int amount;

    public ProductStockChangeRequest(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
