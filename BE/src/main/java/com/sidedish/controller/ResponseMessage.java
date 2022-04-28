package com.sidedish.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseMessage {

    private HttpStatus status;
    private String message;

    public ResponseMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
