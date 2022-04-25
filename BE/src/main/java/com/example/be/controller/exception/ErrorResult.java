package com.example.be.controller.exception;

public class ErrorResult {

    private static final int SERVER_ERROR_CODE = 500;
    private static final String SERVER_ERROR_MESSAGE = "서버 내부 문제입니다.";

    private int code;
    private String message;

    public ErrorResult(int code, String message) {
        this.code = code;
        this.message = message;
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
}

