package com.example.be.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
//    public ResponseEntity<ErrorResponse> businessException(BusinessException exception) {
//        BaseExceptionType baseExceptionType = exception.getBaseExceptionType();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(ErrorResponse.create(baseExceptionType));
//    }
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorResponse> nullPointException(NullPointerException exception) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(ErrorResponse.createAboutNullPointException(exception));
//    }
//
//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> unResolvedException(Exception exception) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ErrorResponse.unResolved(exception));
//    }
}
