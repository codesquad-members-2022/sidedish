package sidedish.web.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDto<T>{
    private String message;
    private int statusCode;
    private T body;

    public ResponseDto(HttpStatus statusCode, T body) {
        this.message = statusCode.name();
        this.statusCode = statusCode.value();
        this.body = body;
    }
}
