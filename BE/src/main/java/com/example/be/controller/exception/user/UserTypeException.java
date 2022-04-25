package com.example.be.controller.exception.user;

import com.example.be.controller.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum UserTypeException implements BaseExceptionType {
    USER_NOT_FOUND_EXCEPTION(404, "해당 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    UserTypeException(int errorCode, String message, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
