package com.sidedish.api;

import lombok.Getter;

@Getter
public class ResultDto {

    private final Boolean valid;
    private final String message;

    public ResultDto(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public static ResultDto ok() {
        return new ResultDto(true, "ok");
    }

    public static ResultDto error(Exception e) {
        return new ResultDto(false, e.getMessage());
    }
}
