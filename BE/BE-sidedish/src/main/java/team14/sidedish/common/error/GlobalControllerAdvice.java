package team14.sidedish.common.error;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {
	public static final String ERROR_OF_SERVER_MESSAGE = "죄송합니다. 잠시후에 다시 이용해주세요.";
	public static final String ERROR_MESSAGE = "correct";
	public static final String EXCEPTION_SEPARATOR = ":";

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(Exception exception) {
		log.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR_OF_SERVER_MESSAGE);
	}

	/**
	 * 요청 바디 데이터 없이 발생 에러
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, HttpServletRequest httpServletRequest) {
		log.error(exception.getMessage());
		String filed = exception.getName();
		MethodParameter message = exception.getParameter();
		String reject = exception.getCause().getMessage();

		ErrorResponse errorResponse = ErrorResponse.oneErrorOfFail(httpServletRequest.getRequestURI(),
			new Error(filed, message.toString(), reject));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	/**
	 * @Valid field 에러
	 * @param exception
	 * @param httpServletRequest
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest httpServletRequest) {
		log.error(exception.getMessage());
		BindingResult bindingResult = exception.getBindingResult();
		Set<Error> errors = bindingResult.getAllErrors().stream()
			.map(error -> {
				FieldError field = (FieldError)error;
				return new Error(field.getField(), field.getDefaultMessage(), field.getRejectedValue().toString());
			}).collect(Collectors.toSet());

		ErrorResponse errorResponse = ErrorResponse.Fail(httpServletRequest.getRequestURI(), errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	/**
	 * json 입력 형식 에러
	 * @param exception
	 * @param httpServletRequest
	 * @return
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity httpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest httpServletRequest) {
		log.error(exception.getMessage());
		String errorCause = exception.getMessage().split(EXCEPTION_SEPARATOR)[0];
		ErrorResponse errorResponse = ErrorResponse.oneErrorOfFail(
			httpServletRequest.getRequestURI(),
			new Error(errorCause, ERROR_MESSAGE, exception.getCause().getMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
