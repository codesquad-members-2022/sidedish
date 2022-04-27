package com.codesquad.sidedish.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

public class User {

    @Id
    private Integer id;
    private String oauthId;
    private String username;
    private String email;

    @Embedded.Nullable
    private GithubToken githubToken;

    public User(String oauthId, String username, String email, GithubToken githubToken) {
        this.oauthId = oauthId;
        this.username = username;
        this.email = email;
        this.githubToken = githubToken;
    }

    public Integer getId() {
        return id;
    }

    public String getOauthId() {
        return oauthId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public GithubToken getGithubToken() {
        return githubToken;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", oauthId='" + oauthId + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", githubToken=" + githubToken +
            '}';
    }
}
