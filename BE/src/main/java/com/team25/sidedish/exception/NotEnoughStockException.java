package com.team25.sidedish.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String message) {
        super(message);
    }
}
