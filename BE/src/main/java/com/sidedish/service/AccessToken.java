package com.sidedish.service;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AccessToken {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getAuthorizationValue() {
        return this.tokenType + " " + this.accessToken;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
            "accessToken='" + accessToken + '\'' +
            ", tokenType='" + tokenType + '\'' +
            '}';
    }
}
