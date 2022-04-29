package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;

public class OAuthException extends SideDishApplicationException {

    public OAuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
