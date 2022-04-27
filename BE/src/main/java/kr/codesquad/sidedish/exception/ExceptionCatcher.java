package kr.codesquad.sidedish.exception;

import kr.codesquad.sidedish.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
        BusinessException businessException) {
        ErrorCode errorCode = businessException.getErrorCode();
        return new ResponseEntity(new ErrorResponse(errorCode.getMessage()), errorCode.getCode());
    }

}
