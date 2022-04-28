package com.team28.sidedish.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = SidedishRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleSidedishRuntimeException(SidedishRuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        log.error(e.getMessage(), e);

        return new ResponseEntity<>(errorResponse, e.getStatus());
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        log.error(e.getMessage(), e);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        log.error(e.getMessage(), e);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
