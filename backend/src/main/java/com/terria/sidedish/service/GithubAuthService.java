package com.terria.sidedish.service;

import com.terria.sidedish.dto.auth.GithubAccessToken;
import com.terria.sidedish.dto.auth.GithubUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource(value = "classpath:oauth.properties", ignoreResourceNotFound = true)
public class GithubAuthService {

    @Value("${oauth.github.clientId}")
    private String clientId;

    @Value("${oauth.github.clientSecret}")
    private String clientSecret;

    public GithubAccessToken requestAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/vnd.github.v3+json");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);

        ResponseEntity<GithubAccessToken> response = new RestTemplate().
                postForEntity(
                        url,
                        new HttpEntity<>(params, headers),
                        GithubAccessToken.class
                );

        return response.getBody();
    }
}
