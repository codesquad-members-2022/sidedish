package kr.codesquad.sidedish.web.dto;

public class ErrorDto {

    private final String errorMessage;

    public ErrorDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
