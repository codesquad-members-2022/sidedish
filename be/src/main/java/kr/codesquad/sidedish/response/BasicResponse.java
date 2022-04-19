package kr.codesquad.sidedish.response;

import java.time.LocalDateTime;

public abstract class BasicResponse {

    protected final LocalDateTime timestamp = LocalDateTime.now();
    protected int statusCode;
    protected String statusName;
    protected String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public String getMessage() {
        return message;
    }
}
