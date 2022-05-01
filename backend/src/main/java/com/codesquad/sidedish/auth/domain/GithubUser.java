package com.codesquad.sidedish.auth.domain;

import com.codesquad.sidedish.order.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class GithubUser {

    @JsonProperty("login")
    private String githubId;

    @JsonProperty("name")
    private String username;

    public User toEntity() {
        return new User(githubId, username);
    }
}
