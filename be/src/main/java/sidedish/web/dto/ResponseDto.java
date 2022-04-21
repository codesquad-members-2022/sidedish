package sidedish.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T>{
    private int statusCode;
    private String message;
    private T body;
}
