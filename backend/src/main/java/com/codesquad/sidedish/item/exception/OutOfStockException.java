package com.codesquad.sidedish.item.exception;

import com.codesquad.sidedish.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class OutOfStockException extends GlobalException {
    public OutOfStockException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
