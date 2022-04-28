package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;

public class SideDishException extends SideDishApplicationException {

    public SideDishException(ErrorCode errorCode) {
        super(errorCode);
    }
}
