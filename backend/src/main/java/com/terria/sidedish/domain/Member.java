package com.terria.sidedish.domain;

import com.terria.sidedish.dto.auth.Provider;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;

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

    private String accessToken;
    private String tokenType;
    private String scope;
}
