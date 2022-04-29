package com.example.be.common.exception.category;

import com.example.be.common.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum CategoryTypeException implements BaseExceptionType {

    CATEGORY_NOT_FOUNT_EXCEPTION(404, "해당 카테고리를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    CategoryTypeException(int errorCode, String message, HttpStatus httpStatus) {
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
