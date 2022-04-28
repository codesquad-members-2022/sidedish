package kr.codesquad.sidedish.dto;

public class ErrorResponse<T> {

    private final T message;

    public T getMessage() {
        return message;
    }

    public ErrorResponse(T message) {
        this.message = message;
    }
}
