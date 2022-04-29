package sidedish.com.exception;

import lombok.Getter;

@Getter
public class NotEnoughStockQuantityException extends RuntimeException {
    private long stockQuantity;

    public NotEnoughStockQuantityException(long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
