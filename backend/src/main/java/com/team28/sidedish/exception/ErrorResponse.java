package com.team28.sidedish.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private int errorCode;
    private String errorName;
    private String errorMessage;
}
