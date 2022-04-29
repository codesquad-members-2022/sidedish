package com.team28.sidedish.exception;

import org.springframework.http.HttpStatus;

public class LoginFailedException extends SidedishRuntimeException {

    public LoginFailedException() {
        super("OAuth 로그인에 실패하였습니다.");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
