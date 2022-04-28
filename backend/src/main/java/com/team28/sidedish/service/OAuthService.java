package com.team28.sidedish.service;

import com.team28.sidedish.controller.dto.OAuthLoginResponse;
import com.team28.sidedish.controller.oauth.OAuthAccessTokenRequest;
import com.team28.sidedish.controller.oauth.OAuthAccessTokenResponse;
import com.team28.sidedish.exception.LoginFailedException;
import com.team28.sidedish.service.dto.UserProfile;
import com.team28.sidedish.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthService {

    private static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";

    private final GithubApiService githubApiService;

    public OAuthLoginResponse login(OAuthAccessTokenRequest request) {
        OAuthAccessTokenResponse accessToken = issueAccessToken(request);
        UserProfile userProfile = githubApiService.getUserProfile(accessToken);

        String token = JwtUtils.createToken(
                Map.of(
                        "email", userProfile.getEmail(),
                        "name", userProfile.getName()
                )
        );

        log.debug(token);
        log.debug("JwtUtils.isValidToken(token) = {}", JwtUtils.isValidToken(token));

        return new OAuthLoginResponse(token);
    }

    private OAuthAccessTokenResponse issueAccessToken(OAuthAccessTokenRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        OAuthAccessTokenResponse accessTokenResponse = restTemplate.postForObject(GITHUB_ACCESS_TOKEN_URL, request, OAuthAccessTokenResponse.class);

        if (accessTokenResponse == null) {
            throw new LoginFailedException();
        }

        log.debug(accessTokenResponse.getAccess_token());
        log.debug(accessTokenResponse.getToken_type());

        return accessTokenResponse;
    }
}
