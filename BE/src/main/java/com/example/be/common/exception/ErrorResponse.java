package com.example.be.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorResponse {

    private static final int SERVER_ERROR_CODE = 500;
    private static final String SERVER_ERROR_MESSAGE = "서버 내부 오류입니다.";

    private int code;
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime time;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public ErrorResponse() {
    }

    static ErrorResponse create(BaseExceptionType baseExceptionType) {
        return new ErrorResponse(baseExceptionType.getErrorCode(), baseExceptionType.getMessage());
    }

    static ErrorResponse createAboutNullPointException(NullPointerException nullPointerException) {
        return new ErrorResponse(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE);
    }

    // TODO. NullPoint를 따로 잡는 것이 좋은 방법일까? 에 대한 질문
    static ErrorResponse unResolved(Exception exception) {
        return new ErrorResponse(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE);
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

