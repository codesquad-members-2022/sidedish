package com.codesquad.sidedish.auth;


import com.codesquad.sidedish.auth.dto.TokenResponse;
import com.codesquad.sidedish.auth.dto.UserResponse;
import com.codesquad.sidedish.order.domain.User;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@PropertySource("classpath:oauth.properties")
public class AuthController {

    private final AuthClient authClient;
    private final AuthService authService;

    @Value("${oauth.client_id}")
    private String clientId;
    @Value("${oauth.redirect_uri}")
    private String redirectUri;

    private final int expiredTime = 86_400;

    @GetMapping("/auth/github")
    public ResponseEntity<Void> githubLogin() {
        URI location = UriComponentsBuilder
            .fromPath("https://github.com/login/oauth/authorize")
            .queryParam("client_id", clientId)
            .queryParam("redirect_uri", redirectUri)
            .build()
            .toUri();

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header(HttpHeaders.LOCATION, location.toString())
            .build();
    }

    @GetMapping("/callback")
    public ResponseEntity<Void> githubCallback(
        @RequestParam(value = "code", required = false) String code) {
        TokenResponse tokenResponse = authClient.getTokenResponse(code);
        UserResponse userResponse = authClient.getUserResponse(tokenResponse.getAccessToken());
        User user = authService.upsertUser(userResponse);

        String accessToken = JwtFactory.create(user, expiredTime);
        ResponseCookie cookie = ResponseCookie.from("access_token", accessToken)
            .maxAge(expiredTime)
            .path("/")
            .build();

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .header(HttpHeaders.LOCATION, "/")
            .build();
    }

}
