package codesquad.sidedish.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResult {

    private HttpStatus status;
    private String errorMessage;

    public ErrorResult(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

}
