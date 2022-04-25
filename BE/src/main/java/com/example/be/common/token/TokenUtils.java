package com.example.be.common.token;

import com.example.be.common.token.configuration.ClientRegistration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public interface TokenUtils {
    HttpEntity<?> getAccessToken(ClientRegistration registration, String code);

    MultiValueMap<String, String> getHeadder();

    MultiValueMap<String, String> getPayLoad(ClientRegistration registration, String code);

    HttpHeaders getAuthorizationIncludedHeader(String accessToken);
}
