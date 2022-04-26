package sidedish.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughStockQuantityException extends RuntimeException {

    public NotEnoughStockQuantityException(String message) {
        super(message);
    }
}
