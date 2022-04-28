package com.terria.sidedish.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.terria.sidedish.domain.Member;
import com.terria.sidedish.domain.entity.aggregate.AccessToken;
import lombok.Getter;

@Getter
public class GitHubUser {

    @JsonProperty("login")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    private String provider;

    private GitHubAccessToken gitHubAccessToken;

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setAccessToken(GitHubAccessToken gitHubAccessToken) {
        this.gitHubAccessToken = gitHubAccessToken;
    }

    public Member toEntity() {
        return new Member(0, userId, Provider.of(provider), email, name, AccessToken.of(gitHubAccessToken));
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
