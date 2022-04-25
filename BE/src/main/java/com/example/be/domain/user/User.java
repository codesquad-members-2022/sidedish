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
    private Bio bio;

}
