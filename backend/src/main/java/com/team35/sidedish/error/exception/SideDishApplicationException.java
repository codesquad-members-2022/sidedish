package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SideDishApplicationException extends RuntimeException {

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
