package kr.codesquad.sidedish.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

	INVALID_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "요청에 필요한 필수 파라미터 값이 입력되지 않았습니다."),

	;

	private final HttpStatus httpStatus;
	private final String detail;
}
