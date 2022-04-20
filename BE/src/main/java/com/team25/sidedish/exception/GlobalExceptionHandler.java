package com.team25.sidedish.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = GlobalRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleGlobalRuntimeException(GlobalRuntimeException e) {
        HttpStatus status = e.getStatus();
        ErrorResponse errorResponse = new ErrorResponse(status.value(), status.name(),
            e.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }
}
