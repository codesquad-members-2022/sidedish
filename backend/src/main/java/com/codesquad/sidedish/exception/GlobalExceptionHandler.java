package com.codesquad.sidedish.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<String> globalExceptionResolver(GlobalException exception) {
        return new ResponseEntity<>(exception.getErrorMessage(), exception.getHttpStatus());
    }
}
