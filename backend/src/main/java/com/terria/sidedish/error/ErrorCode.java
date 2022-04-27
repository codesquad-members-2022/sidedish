package com.terria.sidedish.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    EXHIBITION_VALIDATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "기획전 아이디가 유효하지 않습니다."),
    NO_SUCH_MEMBER_ERROR(HttpStatus.NOT_FOUND, "해당 사용자가 존재하지 않습니다."),
    NO_SUCH_SIDE_DISH_ERROR(HttpStatus.NOT_FOUND, "해당 사용자가 존재하지 않습니다.");

    final HttpStatus status;
    final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
