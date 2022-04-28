package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;

public class OrderException extends SideDishApplicationException {

    public OrderException(ErrorCode errorCode) {
        super(errorCode);
    }
}
