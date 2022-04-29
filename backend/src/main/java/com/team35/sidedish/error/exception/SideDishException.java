package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;

public class SideDishException extends SideDishApplicationException {

    public SideDishException(ErrorCode errorCode) {
        super(errorCode);
    }
}
