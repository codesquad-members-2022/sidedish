package com.codesquad.sidedish.item.exception;

public class CategoryIdNotFoundException extends RuntimeException {
    public CategoryIdNotFoundException() {
        super();
    }

    public CategoryIdNotFoundException(String message) {
        super(message);
    }

    public CategoryIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryIdNotFoundException(Throwable cause) {
        super(cause);
    }
}
