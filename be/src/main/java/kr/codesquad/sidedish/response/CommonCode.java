package kr.codesquad.sidedish.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CommonCode {

	SUCCESS(HttpStatus.OK, "성공"),

	;

	private final HttpStatus httpStatus;
	private final String detail;
}
