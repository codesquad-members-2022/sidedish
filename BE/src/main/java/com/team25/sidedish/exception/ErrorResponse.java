package com.team25.sidedish.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final int statusCode;
    private final String statusName;
    private final String message;
}
