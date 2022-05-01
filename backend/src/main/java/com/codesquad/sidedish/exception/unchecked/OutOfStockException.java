package com.codesquad.sidedish.exception.unchecked;

import com.codesquad.sidedish.exception.ErrorCode;

public class OutOfStockException extends BusinessException {

    public OutOfStockException(ErrorCode errorCode) {
        super(errorCode);
    }
}
