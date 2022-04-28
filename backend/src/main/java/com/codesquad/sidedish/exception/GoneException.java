package com.codesquad.sidedish.exception;

public class GoneException extends BusinessException {

    public GoneException(ErrorCode errorCode) {
        super(errorCode);
    }
}
