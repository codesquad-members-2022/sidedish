package com.team28.sidedish.controller;

import com.team28.sidedish.controller.dto.OAuthLoginResponse;
import com.team28.sidedish.controller.oauth.OAuthAccessTokenRequest;
import com.team28.sidedish.controller.oauth.OAuthUrl;
import com.team28.sidedish.exception.LoginFailedException;
import com.team28.sidedish.service.OAuthService;
import com.team28.sidedish.utils.EnvUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OAuthController {

    private static final String GITHUB_OAUTH_LOGIN_URL = "https://github.com/login/oauth/authorize";
    private static final String GITHUB_OAUTH_SCOPE = "read:user";
    private static final String GITHUB_OAUTH_RESPONSE_TYPE = "code";

    private final OAuthService oAuthService;

    @GetMapping("/auth/github")
    public ResponseEntity<Void> githubAuthorization() {
        String url = OAuthUrl.builder()
                .baseUrl(GITHUB_OAUTH_LOGIN_URL)
                .client_id(EnvUtils.getClientId())
                .redirect_uri(EnvUtils.getRedirectUri())
                .scope(GITHUB_OAUTH_SCOPE)
                .response_type(GITHUB_OAUTH_RESPONSE_TYPE)
                .build();

        return ResponseEntity.status(HttpStatus.SEE_OTHER)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/login/github")
    @ResponseBody
    public OAuthLoginResponse githubLogin(@RequestParam String code) {

        if (Objects.isNull(code)) {
            throw new LoginFailedException();
        }

        String clientId = EnvUtils.getClientId();
        String secretCode = EnvUtils.getSecretCode();

        return oAuthService.login(new OAuthAccessTokenRequest(clientId, secretCode, code));
    }
}
