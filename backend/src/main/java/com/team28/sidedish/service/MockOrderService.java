package com.team28.sidedish.service;

import org.springframework.stereotype.Service;

@Service
public class MockOrderService {

    private final String OUT_OF_STOCK = "재고가 부족합니다.";
    private final int MAX_QUANTITY = 5;

    private boolean isEnoughStockCount(Long productId, int quantity) {
        return quantity <= MAX_QUANTITY;
    }

    private void updateStock(Long productId, int quantity) {
        //TODO 실제 서비스에서는 재고를 업데이트한다
    }

    public void order(Long productId, int quantity) {
        if (!isEnoughStockCount(productId, quantity)) {
            throw new IllegalArgumentException(OUT_OF_STOCK);
        }

        updateStock(productId, quantity);
    }
}
