package com.sidedish.api.common;

import com.sidedish.exception.QuantityException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ResultDto> noSuchElementExceptionHandler(NoSuchElementException e) {
        return ResponseEntity.badRequest().body(ResultDto.error(e));
    }

    @ExceptionHandler
    public ResponseEntity<ResultDto> quantityExceptionHandler(QuantityException e) {
        return ResponseEntity.badRequest().body(ResultDto.error(e));
    }
}
