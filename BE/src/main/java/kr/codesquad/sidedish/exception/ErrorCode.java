package kr.codesquad.sidedish.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    NoDishError(HttpStatus.NOT_FOUND, "찾으시는 디시 없음"),
    NoCategoryError(HttpStatus.NOT_FOUND, "찾으시는 카테고리 없음"),
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
