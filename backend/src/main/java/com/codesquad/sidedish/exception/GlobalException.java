package com.codesquad.sidedish.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {
    private String errorMessage;
    private HttpStatus httpStatus;

    public GlobalException(String errorMessage, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
