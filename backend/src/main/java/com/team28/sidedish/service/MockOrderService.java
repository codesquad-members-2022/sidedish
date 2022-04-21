package com.team28.sidedish.service;

import org.springframework.stereotype.Service;

@Service
public class MockOrderService implements OrderService {

    @Override
    public boolean isEnoughStockCount(Long productId, int quantity) {
        return quantity <= 5;
    }

    @Override
    public void updateStock(Long productId, int quantity) {
        //TODO 실제 서비스에서는 재고를 업데이트한다
    }
}
