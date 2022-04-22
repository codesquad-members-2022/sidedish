package com.example.be.domain.user;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@Getter
public class User {

    @Id
    private Long user_id;
    private String userLoginId;
    private String password;

    public User(String userLoginId, String password) {
        this.userLoginId = userLoginId;
        this.password = password;
    }
}
