package kr.codesquad.sidedish.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class CommonResponse extends BasicResponse {

	private Object data;

	private CommonResponse(CommonCode commonCode) {
		this.statusCode = commonCode.getHttpStatus().value();
		this.statusName = commonCode.getHttpStatus().name();
		this.message = commonCode.getDetail();
	}

	private CommonResponse(CommonCode commonCode, Object data) {
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

	public static CommonResponse noContentCommonResponse() {
		return new CommonResponse(CommonCode.SUCCESS_NO_CONTENT);
	}

	public static CommonResponse okCommonResponse(Object data) {
		return new CommonResponse(CommonCode.SUCCESS, data);
	}
}
