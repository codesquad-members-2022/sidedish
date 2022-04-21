package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Member {

    @Id
    private final Long member_id;
    private final String email;
    private final String password;

    public Member(Long member_id, String email, String password) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
    }

    public Long getMember_id() {
        return member_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
