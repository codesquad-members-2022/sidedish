package kr.codesquad.sidedish.response;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public abstract class BasicResponse {

	protected final LocalDateTime timestamp = LocalDateTime.now();
	protected int statusCode;
	protected String statusName;
	protected String message;
}
