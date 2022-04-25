package com.terria.sidedish.error;

import com.terria.sidedish.dto.auth.Provider;
import org.springframework.http.HttpStatus;

public enum ErrorCode {

    EXHIBITION_VALIDATION_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "기획전 아이디가 유효하지 않습니다."
    );

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
