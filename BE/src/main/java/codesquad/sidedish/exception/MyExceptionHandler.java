package codesquad.sidedish.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(NotEnoughStockException.class)
    public ResponseEntity<ErrorResult> handleNotEnoughException(NotEnoughStockException e) {
        log.error("[Exception Handle] Exception = {}", e.getMessage());
        ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResult> handleItemNotFoundException(ItemNotFoundException e) {
        log.error("[Exception Handle] Exception = {}", e.getMessage());
        ErrorResult errorResult = new ErrorResult(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

}
