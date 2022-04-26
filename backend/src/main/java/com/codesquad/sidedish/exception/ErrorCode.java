package com.codesquad.sidedish.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    DISH_NOT_FOUND(HttpStatus.NOT_FOUND, "반찬을 찾을 수 없습니다."),
    DELIVERY_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 배달 코드가 존재하지 않습니다."),
    DISCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 할인 코드가 존재하지 않습니다."),
    DISH_OUT_OF_STOCK(HttpStatus.GONE, "반찬의 재고가 부족합니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
