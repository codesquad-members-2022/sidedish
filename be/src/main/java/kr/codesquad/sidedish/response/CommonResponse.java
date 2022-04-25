package kr.codesquad.sidedish.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponse extends BasicResponse {

	private Object data;

	public CommonResponse(CommonCode commonCode) {
		this.statusCode = commonCode.getHttpStatus().value();
		this.statusName = commonCode.getHttpStatus().name();
		this.message = commonCode.getDetail();
	}

	public CommonResponse(CommonCode commonCode, Object data) {
		this.statusCode = commonCode.getHttpStatus().value();
		this.statusName = commonCode.getHttpStatus().name();
		this.message = commonCode.getDetail();
		this.data = data;
	}

	public ResponseEntity<CommonResponse> toResponseEntity() {
		return ResponseEntity
			.status(HttpStatus.valueOf(statusCode))
			.body(this);
	}

	public Object getData() {
		return data;
	}
}
