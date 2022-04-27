package com.team28.sidedish.exception;

import org.springframework.http.HttpStatus;

public class OutOfStockException extends SidedishRuntimeException {

    public OutOfStockException() {
        super("재고가 부족합니다.");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
