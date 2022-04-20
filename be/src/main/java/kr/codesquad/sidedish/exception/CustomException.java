package kr.codesquad.sidedish.exception;

import kr.codesquad.sidedish.response.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CustomException extends RuntimeException {

	private final ErrorCode errorCode;
}
