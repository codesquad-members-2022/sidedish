package kr.codesquad.sidedish.response;

import org.springframework.http.HttpStatus;

public enum CommonCode {

    SUCCESS(HttpStatus.OK, "성공"),

    ;

    private final HttpStatus httpStatus;
    private final String detail;

    CommonCode(HttpStatus httpStatus, String detail) {
        this.httpStatus = httpStatus;
        this.detail = detail;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDetail() {
        return detail;
    }
}
