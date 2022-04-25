package com.example.be.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResult> businessException(BusinessException exception) {
        BaseExceptionType baseExceptionType = exception.getBaseExceptionType();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorResult.create(baseExceptionType));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResult> unResolvedException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResult.unResolved(exception));
    }
}
