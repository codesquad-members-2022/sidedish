package com.team28.sidedish.controller.oauth;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OAuthAccessTokenResponse {

    private String access_token;
    private String scope;
    private String token_type;
}
