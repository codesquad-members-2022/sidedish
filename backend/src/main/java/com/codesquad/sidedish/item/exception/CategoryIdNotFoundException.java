package com.codesquad.sidedish.item.exception;

import com.codesquad.sidedish.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class CategoryIdNotFoundException extends GlobalException {
    public CategoryIdNotFoundException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
