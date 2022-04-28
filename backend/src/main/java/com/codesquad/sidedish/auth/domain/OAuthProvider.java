package com.codesquad.sidedish.auth.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OAuthProvider {

    // client
    private String clientId;
    private String clientSecret;
    private String redirectUri;

    // path
    private String authorizePath;
    private String accessTokenPath;
    private String resourcePath;

}
