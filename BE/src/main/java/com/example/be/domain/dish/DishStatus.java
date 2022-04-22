package com.example.be.domain.dish;

import lombok.Getter;

@Getter
public enum DishStatus {

    IN_STOCK("주문 가능"),
    OUT_OT_STOCK("재고 없음");

    private final String status;

    DishStatus(String status) {
        this.status = status;
    }
}
