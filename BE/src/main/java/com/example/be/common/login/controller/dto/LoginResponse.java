package com.example.be.common.login.controller.dto;

public class LoginResponse {

    private String name;

    public LoginResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
