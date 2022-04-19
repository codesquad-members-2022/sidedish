package kr.codesquad.sidedish.dto;

public class ApiResponse {
    private final String success;
    private final String message;
    private final Object data;

    public ApiResponse(String success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
