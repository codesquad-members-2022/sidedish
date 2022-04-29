package team14.sidedish.common.error;

import org.springframework.http.HttpStatus;

import java.util.Set;
import java.util.function.BiFunction;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class ErrorResponse {
	public static final BiFunction<String, String, String> ERROR_LOG = (cause, errorOfdata) ->
		String.format("%s : %s", cause, errorOfdata);
	private final String statusCode;
	private final ResultCode result;
	private final String requestUrl;
	private final Set<Error> errorList;

	@Getter
	@RequiredArgsConstructor
	public enum ResultCode {
		FAIL("FAIL");
		private final String text;
	}

	@Builder
	private ErrorResponse(String statusCode, ResultCode result, String requestUrl,
		Set<Error> errorList) {
		this.statusCode = statusCode;
		this.result = result;
		this.requestUrl = requestUrl;
		this.errorList = errorList;
	}

	public static ErrorResponse oneErrorOfFail(String requestUrl, Error error) {
		return ErrorResponse.builder()
			.statusCode(HttpStatus.BAD_REQUEST.toString())
			.result(ErrorResponse.ResultCode.FAIL)
			.requestUrl(requestUrl)
			.errorList(Set.of(error))
			.build();
	}

	public static ErrorResponse Fail(String requestUrl, Set<Error> errorList) {
		return ErrorResponse.builder()
			.statusCode(HttpStatus.BAD_REQUEST.toString())
			.result(ErrorResponse.ResultCode.FAIL)
			.requestUrl(requestUrl)
			.errorList(errorList)
			.build();
	}
}
