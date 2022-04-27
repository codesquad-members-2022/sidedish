package com.codesquad.sidedish.item.exception;

import com.codesquad.sidedish.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class ItemIdNotFoundException extends GlobalException {
    public ItemIdNotFoundException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
