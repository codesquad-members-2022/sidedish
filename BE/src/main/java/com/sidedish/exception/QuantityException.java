package com.sidedish.exception;

public class QuantityException extends RuntimeException {
    public QuantityException() {
        super("수량부족");
    }
}
