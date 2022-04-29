package com.team28.sidedish.service;

import com.team28.sidedish.controller.oauth.OAuthAccessTokenResponse;
import com.team28.sidedish.exception.LoginFailedException;
import com.team28.sidedish.service.dto.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GithubApiService {

    private static final String GITHUB_USER_API = "https://api.github.com/user";

    public UserProfile getUserProfile(OAuthAccessTokenResponse accessToken) {

        String AuthorizationValue = formatAuthorizationValue(accessToken);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", AuthorizationValue);
        HttpEntity<Void> httpEntity = new HttpEntity<>(null, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserProfile> responseEntity = restTemplate.exchange(GITHUB_USER_API, HttpMethod.GET, httpEntity, UserProfile.class);

        UserProfile profile = responseEntity.getBody();

        if (profile == null) {
            throw new LoginFailedException();
        }

        log.debug(profile.toString());

        return profile;
    }

    private String formatAuthorizationValue(OAuthAccessTokenResponse accessToken) {
        return String.format("%s %s", accessToken.getToken_type(), accessToken.getAccess_token());
    }

}
