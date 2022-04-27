package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.auth.dto.TokenResponse;
import com.codesquad.sidedish.auth.dto.UserResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@PropertySource("classpath:oauth.properties")
public class AuthClient {

    @Value("${oauth.client_id}")
    private String clientId;
    @Value("${oauth.client_secret}")
    private String clientSecret;

    public TokenResponse getTokenResponse(String code) {
        return WebClient.create()
            .post()
            .uri(URI.create("https://github.com/login/oauth/access_token"))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .accept(MediaType.APPLICATION_JSON)
            .acceptCharset(StandardCharsets.UTF_8)
            .bodyValue(createTokenBody(code))
            .retrieve()
            .bodyToMono(TokenResponse.class)
            .block();
    }

    public UserResponse getUserResponse(String accessToken) {
        return WebClient.create()
            .get()
            .uri(URI.create("https://api.github.com/user"))
            .header(HttpHeaders.ACCEPT, "application/vnd.github.v3+json")
            .header(HttpHeaders.AUTHORIZATION, "token " + accessToken)
            .retrieve()
            .bodyToMono(UserResponse.class)
            .block();
    }

    private MultiValueMap<String, Object> createTokenBody(String code) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("code", code);
        return body;
    }

}
