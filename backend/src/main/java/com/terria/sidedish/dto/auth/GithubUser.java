package com.terria.sidedish.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.terria.sidedish.domain.Member;
import lombok.Getter;

@Getter
public class GithubUser {

    @JsonProperty("login")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    private String provider;

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Member toEntity() {
        return new Member(0, userId, Provider.of(provider), email, name);
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
