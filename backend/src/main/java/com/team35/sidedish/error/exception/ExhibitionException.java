package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;

public class ExhibitionException extends SideDishApplicationException {

    public ExhibitionException(ErrorCode errorCode) {
        super(errorCode);
    }
}
