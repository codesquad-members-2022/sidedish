package com.team25.sidedish.exception;

public class ProductNotExistException extends NotExistException {

    public ProductNotExistException() {
        super("해당 아이디의 제품이 존재하지 않습니다");
    }
}
