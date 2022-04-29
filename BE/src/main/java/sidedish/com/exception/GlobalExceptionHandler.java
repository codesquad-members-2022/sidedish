package sidedish.com.exception;

import java.util.Collections;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NotEnoughStockQuantityException.class)
	public Map<String, Long> exceptionHandler(NotEnoughStockQuantityException e) {
		long stockQuantity = e.getStockQuantity();
		return Collections.singletonMap("currentStockQuantity", stockQuantity);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchProductsException.class)
	public void exceptionHandler(NoSuchProductsException e) {
	}
}
