package com.example.be.controller.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GithubToken {

    private static final String TOKEN_DELIMETER = " ";

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("scope")
    private String scope;

    public String getGithubAccessToken() {
        return tokenType + TOKEN_DELIMETER + accessToken;
    }

    @Override
    public String toString() {
        return "GithubToken{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
