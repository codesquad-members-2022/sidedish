package com.sidedish.api.categories;

import lombok.Getter;

@Getter
public class ResultDto {

    private final String code;
    private final String message;

    public ResultDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
