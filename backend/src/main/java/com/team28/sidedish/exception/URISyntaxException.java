package com.team28.sidedish.exception;

import org.springframework.http.HttpStatus;

public class URISyntaxException extends SidedishRuntimeException {

    public URISyntaxException() {
        super("URI 형식이 잘못되었습니다.");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
