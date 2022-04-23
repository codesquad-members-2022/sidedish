package com.terria.sidedish.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUser {

    @JsonProperty("login")
    private String userId;

    @JsonProperty("email")
    private String email;

    @Override
    public String toString() {
        return "GithubUser{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
