package com.codesquad.sidedish.user.domain;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private Integer id;
    private String oauthId;
    private String username;
    private String email;

    public User(String oauthId, String username, String email) {
        this.oauthId = oauthId;
        this.username = username;
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", oauthId='" + oauthId + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
