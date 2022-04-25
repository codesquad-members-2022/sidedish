package com.example.be.controller.exception.dish;

import com.example.be.controller.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum DishTypeException implements BaseExceptionType {

    DISH_NOT_FOUND_EXCEPTION(404, "해당 음식을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    DishTypeException(int errorCode, String message, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
