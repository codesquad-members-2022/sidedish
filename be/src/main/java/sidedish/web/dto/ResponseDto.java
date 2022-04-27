package sidedish.web.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDto<T>{
    private int result_code;
    private String result_message;
    private T result_body;

    public ResponseDto(HttpStatus result_code, T result_body) {
        this.result_message = result_code.name();
        this.result_code = result_code.value();
        this.result_body = result_body;
    }
}
