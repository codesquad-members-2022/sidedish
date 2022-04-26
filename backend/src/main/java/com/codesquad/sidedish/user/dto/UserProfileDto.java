package com.codesquad.sidedish.user.dto;

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
}
