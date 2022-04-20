package com.team25.sidedish.exception;

import org.springframework.http.HttpStatus;

public abstract class GlobalRuntimeException extends RuntimeException {

    public GlobalRuntimeException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();
}
