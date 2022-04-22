package com.example.be.controller.exception;

public class ErrorResult {

    private int code;
    private String message;

    public ErrorResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    static ErrorResult create(BaseExceptionType baseExceptionType) {
        return new ErrorResult(baseExceptionType.getErrorCode(), baseExceptionType.getMessage());
    }

    static ErrorResult unResolved(Exception exception) {
        return new ErrorResult(500, "서버 내부 문제입니다.");
    }
}

