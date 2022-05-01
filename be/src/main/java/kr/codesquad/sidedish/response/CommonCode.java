package kr.codesquad.sidedish.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CommonCode {

	SUCCESS(HttpStatus.OK, "성공"),
	SUCCESS_NO_CONTENT(HttpStatus.OK, HttpStatus.NO_CONTENT.getReasonPhrase()),

	;

	private final HttpStatus httpStatus;
	private final String detail;
}
