package com.sidedish.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseMessage {

    private final HttpStatus status;
    private final String message;
    private String email;

    public ResponseMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseMessage(HttpStatus status, String message, String email) {
        this.status = status;
        this.message = message;
        this.email = email;
    }
}
