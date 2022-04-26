package kr.codesquad.sidedish.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

	INVALID_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "요청에 필요한 필수 파라미터 값이 입력되지 않았습니다."),
	DISH_TYPE_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "존재하지 않는 요리 타입이 입력 되었습니다."),
	SIDE_DISH_TYPE_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "존재하지 않는 반찬 타입이 입력 되었습니다."),
	SIDE_DISH_ONLY_ALLOWED(HttpStatus.BAD_REQUEST, "반찬 타입 조회는 요리 타입이 반찬인 경우에만 가능합니다."),
	PRODUCT_ID_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "존재하지 않는 상품 ID가 입력 되었습니다."),
	PRODUCT_QUANTITY_insufficient(HttpStatus.BAD_REQUEST, "현재 상품의 재고가 요청한 값보다 부족합니다."),
	;

	private final HttpStatus httpStatus;
	private final String detail;
}
