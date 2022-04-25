package com.example.be.common.token.github;

import com.example.be.common.token.TokenUtils;
import com.example.be.common.token.configuration.ClientRegistration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class GithubTokenUtils implements TokenUtils {

    public static final String USER_INFORMATION_REQUEST_URL = "https://api.github.com/user";
    public static final String USER_PUBLIC_EMAIL = "https://api.github.com/user/public_emails";

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String CODE = "code";


    @Override
    public HttpEntity<?> getAccessToken(ClientRegistration registration, String code) {
        Assert.notNull(registration, "Registration must be not null.");
        Assert.notNull(code, "Code must be not null.");

        MultiValueMap<String, String> headers = getHeadder();
        MultiValueMap<String, String> payLoad = getPayLoad(registration, code);
        return new HttpEntity<>(payLoad, headers);
    }

    @Override
    public MultiValueMap<String, String> getHeadder() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        return headers;
    }

    @Override
    public MultiValueMap<String, String> getPayLoad(ClientRegistration registration, String code) {
        MultiValueMap<String, String> payLoad = new LinkedMultiValueMap<>();
        payLoad.set(CLIENT_ID, registration.getClientId());
        payLoad.set(CLIENT_SECRET, registration.getClientSecret());
        payLoad.set(CODE, code);
        return payLoad;
    }

    @Override
    public HttpHeaders getAuthorizationIncludedHeader(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, accessToken);
        return headers;
    }
}
