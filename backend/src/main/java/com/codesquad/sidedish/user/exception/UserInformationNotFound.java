package com.codesquad.sidedish.user.exception;

import org.springframework.http.HttpStatus;

import com.codesquad.sidedish.exception.GlobalException;

public class UserInformationNotFound extends GlobalException {
    public UserInformationNotFound(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
