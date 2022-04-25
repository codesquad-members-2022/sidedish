package com.example.be.domain.user;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Getter
public class User {

    @Id
    private Long userId;
    private String name;
    private String username;
    private String avatarUrl;
    private String email;
    private String location;
    private Bio bio;

    public User(Long userId, String name, String username, String avatarUrl, String email, String location, Bio bio) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.location = location;
        this.bio = bio;
    }
}
