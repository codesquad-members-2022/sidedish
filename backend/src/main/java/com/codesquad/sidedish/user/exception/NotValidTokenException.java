package com.codesquad.sidedish.user.exception;

import org.springframework.http.HttpStatus;

import com.codesquad.sidedish.exception.GlobalException;

public class NotValidTokenException extends GlobalException {
    public NotValidTokenException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
