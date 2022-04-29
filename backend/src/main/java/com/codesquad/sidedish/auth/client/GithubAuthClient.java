package com.codesquad.sidedish.auth.client;

import com.codesquad.sidedish.auth.domain.GithubToken;
import com.codesquad.sidedish.auth.domain.GithubUser;
import com.codesquad.sidedish.auth.domain.OAuthProperties;
import com.codesquad.sidedish.auth.domain.OAuthProvider;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GithubAuthClient implements AuthClient<GithubToken, GithubUser> {

    private final OAuthProvider provider;

    GithubAuthClient(OAuthProperties properties) {
        this.provider = properties.getProvider("github");
    }

    public GithubToken getToken(String code) {
        return WebClient.create()
            .post()
            .uri(URI.create(provider.getAccessTokenPath()))
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(createTokenBody(code))
            .retrieve()
            .bodyToMono(GithubToken.class)
            .block();
    }

    public GithubUser getUser(String accessToken) {
        return WebClient.create()
            .get()
            .uri(URI.create(provider.getResourcePath()))
            .header(HttpHeaders.ACCEPT, "application/vnd.github.v3+json")
            .header(HttpHeaders.AUTHORIZATION, "token " + accessToken)
            .retrieve()
            .bodyToMono(GithubUser.class)
            .block();
    }

    private MultiValueMap<String, Object> createTokenBody(String code) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("client_id", provider.getClientId());
        body.add("client_secret", provider.getClientSecret());
        body.add("code", code);
        return body;
    }

}
