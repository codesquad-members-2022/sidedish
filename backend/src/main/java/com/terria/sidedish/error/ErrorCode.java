package com.terria.sidedish.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    EXHIBITION_VALIDATION_ERROR("E001", HttpStatus.INTERNAL_SERVER_ERROR, "기획전 아이디가 유효하지 않습니다.");

    final String code;
    final HttpStatus status;
    final String message;

    ErrorCode(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
