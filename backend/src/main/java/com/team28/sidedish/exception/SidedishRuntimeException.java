package com.team28.sidedish.exception;

import org.springframework.http.HttpStatus;

public abstract class SidedishRuntimeException extends RuntimeException {

    // TODO 사용자 정의 예외에서 에러 메세지는 외부에서 주입받지 않고, 내부에 정의한다.
    public SidedishRuntimeException(String message) {
        super(message);
    }

    // TODO 다른 예외와 함게 발생하는 경우, 중첩 예외를 활용한다.
    public SidedishRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();
}
