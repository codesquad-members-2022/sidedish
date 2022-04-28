package team14.sidedish.common.Exception;

import lombok.Getter;

@Getter
public class InvalidOrderException extends RuntimeException{
	public static final String ERROR_OF_ORDER_TOTAL_PRICE = "총 결제 금액이 잘못 됐습니다.";
	public static final String ERROR_OF_ORDER_DEVLIVERY_CHARGE = "배송비가 잘못 됐습니다.";
	public static final String ERROR_OF_ORDER_SAVED_CHARGE = "적립금액이 잘못 됐습니다.";
	public static final String ERROR_OF_ORDER_IN_SOLD_OUT = "죄송합니다. 품절 됐습니다.";

	private String value;
	private String invalidValue;
	public InvalidOrderException(String message) {
		super(message);
	}

	public InvalidOrderException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidOrderException(Object value, String message, Object invalidValue) {
		super(message);
		this.value = String.valueOf(value);
		this.invalidValue = String.valueOf(invalidValue);
	}
}
