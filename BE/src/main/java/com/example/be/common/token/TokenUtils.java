package com.example.be.common.token;

import com.example.be.common.token.configuration.ClientRegistration;
import com.example.be.common.token.github.GithubToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface TokenUtils {
    HttpEntity<?> getAccessTokenRequest(ClientRegistration registration, String code);

    MultiValueMap<String, String> getHeadder();

    MultiValueMap<String, String> getPayLoad(ClientRegistration registration, String code);

    HttpHeaders getAuthorizationIncludedHeader(String accessToken);

    Map<String, String> getUserDetail(String body);

    Map<String, String> getUserDetailFrom(ClientRegistration clientRegistration, GithubToken gitToken);
}
