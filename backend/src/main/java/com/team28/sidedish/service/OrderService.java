package com.team28.sidedish.service;

public interface OrderService {

    boolean isEnoughStockCount(Long productId, int quantity);

    void updateStock(Long productId, int quantity);
}
