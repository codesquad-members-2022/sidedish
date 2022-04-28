package com.sidedish.service;

import com.sidedish.domain.User;
import com.sidedish.repository.UserRepository;
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

    private final UserRepository userRepository;

    private static final String CLIENT_ID = "52d17ef5577e55a18ca3";
    private static final String GITHUB_AUTHORIZATION_SERVER_URL = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_RESOURCE_SERVER_EMAIL_API_URL = "https://api.github.com/user/emails";
    private static final String GITHUB_EMAIL_API_ACCEPT_HEADER = "application/vnd.github.v3+json";

    public AccessToken getAccessToken(String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json");
        headers.setAll(header);

        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", CLIENT_ID);
        requestPayload.put("client_secret", System.getenv("CLIENT_SECRET"));
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        HttpEntity<?> request = new HttpEntity<>(requestPayloads, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(
            GITHUB_AUTHORIZATION_SERVER_URL, request, AccessToken.class);
        return (AccessToken) response.getBody();
    }

    public List<String> getUserEmails(AccessToken accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", GITHUB_EMAIL_API_ACCEPT_HEADER);
        httpHeaders.set("Authorization", accessToken.getAuthorizationValue());

        HttpEntity<?> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<Object[]> response = new RestTemplate().exchange(
            GITHUB_RESOURCE_SERVER_EMAIL_API_URL,
            HttpMethod.GET,
            request,
            Object[].class
        );

        Object[] userEmails = response.getBody();

        String publicEmail = (String) ((LinkedHashMap) userEmails[0]).get("email");
        String privateEmail = (String) ((LinkedHashMap) userEmails[1]).get("email");

        return List.of(publicEmail, privateEmail);
    }

    public void saveUserEmail(List<String> userEmails) {
        String publicEmail = userEmails.get(0);
        String privateEmail = userEmails.get(1);

        Integer userId = userRepository.findIdByEmail(publicEmail);
        if (userId == null) {
            User user = new User(null, publicEmail, privateEmail);
            userRepository.save(user);
        }
    }
}
