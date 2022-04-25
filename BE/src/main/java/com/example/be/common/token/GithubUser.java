package com.example.be.common.token;

import com.example.be.domain.user.Bio;

public class GithubUser {
    private final String username;
    private final String email;
    private final String name;
    private final String avatarUrl;
    private final Bio bio;
    private final String location;

    public GithubUser(String username, String email, String name, String avatarUrl, Bio bio, String location) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Bio getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }
}
