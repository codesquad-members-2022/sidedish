package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;

public class OrderException extends SideDishApplicationException {

    public OrderException(ErrorCode errorCode) {
        super(errorCode);
    }
}
