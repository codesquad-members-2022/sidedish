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

@RestControllerAdvice
public class GlobalControllerAdvice {

	public static final String ERROR_MESSAGE = "correct";

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(Exception exception) {
		System.out.println("에러 클래스 확인하기 ! ");
		System.out.println(exception.getClass().getName());
		System.out.println(exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/**
	 * 요청 바디 데이터 없이 발생 에러
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, HttpServletRequest httpServletRequest) {
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
		String errorCause = exception.getMessage().split(":")[0];
		ErrorResponse errorResponse = ErrorResponse.oneErrorOfFail(
			httpServletRequest.getRequestURI(),
			new Error(errorCause, ERROR_MESSAGE, exception.getCause().getMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
