package com.codesquad.sidedish.user.exception;

import org.springframework.http.HttpStatus;

import com.codesquad.sidedish.exception.GlobalException;

public class NoTokenException extends GlobalException {
    public NoTokenException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
