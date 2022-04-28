package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;

public class ExhibitionException extends SideDishApplicationException {

    public ExhibitionException(ErrorCode errorCode) {
        super(errorCode);
    }
}
