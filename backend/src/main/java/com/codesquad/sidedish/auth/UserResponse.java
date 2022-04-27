package com.codesquad.sidedish.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserResponse {

    private final String githubId;
    private final String username;
}
