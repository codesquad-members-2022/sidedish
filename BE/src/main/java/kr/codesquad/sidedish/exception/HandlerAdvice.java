package kr.codesquad.sidedish.exception;

import kr.codesquad.sidedish.web.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorDto> IllegalStateExceptionHandle (final IllegalStateException ex){
       ErrorDto errorDto = new ErrorDto(ex.getMessage());
       return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);

    }
}
