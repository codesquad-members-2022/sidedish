package com.example.be.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("user")
public class User {

    @Id
    private Long userId;
    private String name;
    private String username;
    private String avatarUrl;
    private String email;
    private String location;
    private Bio bio;

    @PersistenceConstructor
    public User(Long userId, String name, String username, String avatarUrl, String email, String location, Bio bio) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.location = location;
        this.bio = bio;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public Bio getBio() {
        return bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
