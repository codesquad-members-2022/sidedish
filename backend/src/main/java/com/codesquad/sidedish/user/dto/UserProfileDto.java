package com.codesquad.sidedish.user.dto;

import com.codesquad.sidedish.user.domain.GithubToken;
import com.codesquad.sidedish.user.domain.User;

public class UserProfileDto {

    private String oauthId;
    private String email;
    private String name;

    public UserProfileDto(String oauthId, String email, String name) {
        this.oauthId = oauthId;
        this.email = email;
        this.name = name;
    }

    public String getOauthId() {
        return oauthId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public User toEntity(GithubToken token) {
        return new User(oauthId, name, email, token);
    }
}
