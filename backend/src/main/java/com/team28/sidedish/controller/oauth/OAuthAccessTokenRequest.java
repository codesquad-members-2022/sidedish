package com.team28.sidedish.controller.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OAuthAccessTokenRequest {

    private final String client_id;
    private final String client_secret;
    private final String code;
}
