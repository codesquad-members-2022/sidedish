package com.example.be.common.exception.common;

import com.example.be.common.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum InternalServerException implements BaseExceptionType {

    INTERNAL_SERVER_ERROR(500, "서버 내부 오류입니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    InternalServerException(int errorCode, String message, HttpStatus httpStatus) {
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
