package com.codesquad.sidedish.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UserResponse {

    @JsonProperty("login")
    private String githubId;

    @JsonProperty("name")
    private String username;
}
