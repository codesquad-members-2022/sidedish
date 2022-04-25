package com.codesquad.sidedish.user.dto;

public class LoginResponse {
    private String tokenType;
    private String accessToken;

    public LoginResponse(String tokenType, String accessToken) {
        this.tokenType = tokenType;
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
