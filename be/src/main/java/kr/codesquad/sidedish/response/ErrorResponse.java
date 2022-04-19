package kr.codesquad.sidedish.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse extends BasicResponse {

    public ErrorResponse(ErrorCode errorCode) {
        this.statusCode = errorCode.getHttpStatus().value();
        this.statusName = errorCode.getHttpStatus().name();
        this.message = errorCode.getDetail();
    }

    public ResponseEntity<ErrorResponse> toResponseEntity() {
        return ResponseEntity
                .status(HttpStatus.valueOf(statusCode))
                .body(this);
    }
}
