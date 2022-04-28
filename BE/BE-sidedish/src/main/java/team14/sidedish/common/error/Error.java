package team14.sidedish.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
	private String field;
	private String errorMessage;
	private String invalidValue;
}
