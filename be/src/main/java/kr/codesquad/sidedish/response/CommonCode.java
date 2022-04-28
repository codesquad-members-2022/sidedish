package kr.codesquad.sidedish.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CommonCode {

	SUCCESS(HttpStatus.OK, "성공"),
	SUCCESS_NO_CONTENT(HttpStatus.OK, "요청에 성공했으나 응답할 데이터가 없습니다."),

	;

	private final HttpStatus httpStatus;
	private final String detail;
}
