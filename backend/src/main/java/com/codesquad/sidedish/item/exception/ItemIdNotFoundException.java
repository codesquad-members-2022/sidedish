package com.codesquad.sidedish.item.exception;

public class ItemIdNotFoundException extends RuntimeException {
    public ItemIdNotFoundException() {
        super();
    }

    public ItemIdNotFoundException(String message) {
        super(message);
    }

    public ItemIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemIdNotFoundException(Throwable cause) {
        super(cause);
    }
}
