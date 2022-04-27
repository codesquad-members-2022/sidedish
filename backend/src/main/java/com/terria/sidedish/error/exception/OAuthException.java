package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;

public class OAuthException extends SideDishApplicationException {

    public OAuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
