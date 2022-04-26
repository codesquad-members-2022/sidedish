package com.team28.sidedish.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends SidedishRuntimeException {

    public ProductNotFoundException() {
        super("상품을 찾을 수 없습니다.");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
