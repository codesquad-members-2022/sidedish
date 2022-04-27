package com.sidedish.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class LoginService {

    private final String url = "https://github.com/login/oauth/access_token";

    public String getUserEmail(String code) {
        AccessToken accessToken = getAccessToken(code);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/vnd.github.v3+json");
        httpHeaders.set("Authorization", accessToken.getAuthorizationValue());

        HttpEntity<?> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Object[]> response = new RestTemplate().exchange(
            "https://api.github.com/user/emails",
            HttpMethod.GET,
            request,
            Object[].class
        );
        Object[] userEmails = response.getBody();
        LinkedHashMap primaryEmail = (LinkedHashMap) userEmails[0];

        return (String) primaryEmail.get("email");
    }

    private AccessToken getAccessToken(String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json"); //json 형식으로 응답 받음
        headers.setAll(header);

        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", "52d17ef5577e55a18ca3");
        requestPayload.put("client_secret", "e60b022aea41c5af02238dd77a93db8fb9df5c48");
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        HttpEntity<?> request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, AccessToken.class);
        return (AccessToken) response.getBody();
    }

}
