package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private final Long user_id;
    private final String email;
    private final String password;

    public User(Long user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
