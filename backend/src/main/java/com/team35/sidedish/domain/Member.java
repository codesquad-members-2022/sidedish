package com.team35.sidedish.domain;

import com.team35.sidedish.domain.entity.aggregate.AccessToken;
import com.team35.sidedish.dto.auth.Provider;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = {"userId", "provider"})
public class Member {

    @Id
    private long id;
    private String userId;
    private Provider provider;
    private String email;
    private String name;

    @Embedded.Nullable
    private AccessToken accessToken;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", provider=" + provider +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", accessToken=" + accessToken +
                '}';
    }
}
