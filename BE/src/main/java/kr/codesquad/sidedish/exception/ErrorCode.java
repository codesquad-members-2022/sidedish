package kr.codesquad.sidedish.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    NoDishError(HttpStatus.NOT_FOUND, "찾으시는디시없음"),
    NoCategoryError(HttpStatus.NOT_FOUND, "찾으시는카테고리없음"),
    NotEnoughDishStockError(HttpStatus.NOT_FOUND, "수량 부족");

    private HttpStatus code;
    private String message;

    ErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
