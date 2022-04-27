package com.sidedish.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEmail {


    @JsonProperty
    private String email;
    @JsonProperty
    private boolean verified;
    @JsonProperty
    private boolean primary;
    @JsonProperty
    private String visibility;

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserEmail{" +
            "email='" + email + '\'' +
            ", verified=" + verified +
            ", primary=" + primary +
            ", visibility='" + visibility + '\'' +
            '}';
    }
}
