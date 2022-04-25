package com.example.be.controller.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResult> businessException(BusinessException exception) {
        return new ResponseEntity<>(ErrorResult.create(exception.getBaseExceptionType()), exception.getBaseExceptionType().getHttpStatus());
    }

}
