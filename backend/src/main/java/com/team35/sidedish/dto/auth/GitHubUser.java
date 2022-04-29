package com.team35.sidedish.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team35.sidedish.domain.entity.aggregate.AccessToken;
import com.team35.sidedish.domain.Member;
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
