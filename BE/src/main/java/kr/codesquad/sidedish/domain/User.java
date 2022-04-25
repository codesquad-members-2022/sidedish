package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private final Long userId;
    private final String email;
    private final String password;

    public User(Long user_id, String email, String password) {
        this.userId = user_id;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
