package com.terria.sidedish.error;

import com.terria.sidedish.error.exception.ExhibitionException;
import com.terria.sidedish.error.exception.OAuthException;
import com.terria.sidedish.error.exception.SideDishException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerAdvice {
    
    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ErrorResponse<List<String>>> handleConstraintViolationException(ConstraintViolationException e) {
        List<String> messages = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ErrorResponse<>(messages), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OAuthException.class)
    private ResponseEntity<ErrorResponse<String>> handleOAuthException(OAuthException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse<>(errorCode.getMessage()), errorCode.getStatus());
    }

    @ExceptionHandler(ExhibitionException.class)
    private ResponseEntity<ErrorResponse<String>> handleExhibitionException(ExhibitionException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse<>(errorCode.getMessage()), errorCode.getStatus());
    }

    @ExceptionHandler(SideDishException.class)
    private ResponseEntity<ErrorResponse<String>> handleSideDishException(SideDishException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse<>(errorCode.getMessage()), errorCode.getStatus());
    }
}
