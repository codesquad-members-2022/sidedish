package com.example.be.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorResult {

    private static final int SERVER_ERROR_CODE = 500;
    private static final String SERVER_ERROR_MESSAGE = "서버 내부 오류입니다.";

    private int code;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime time;

    public ErrorResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public ErrorResult() {
    }

    static ErrorResult create(BaseExceptionType baseExceptionType) {
        return new ErrorResult(baseExceptionType.getErrorCode(), baseExceptionType.getMessage());
    }

    static ErrorResult unResolved(Exception exception) {
        return new ErrorResult(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}

