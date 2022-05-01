package com.codesquad.sidedish.auth.controller;


import com.codesquad.sidedish.auth.AuthService;
import com.codesquad.sidedish.auth.JwtFactory;
import com.codesquad.sidedish.auth.client.GithubAuthClient;
import com.codesquad.sidedish.auth.domain.GithubToken;
import com.codesquad.sidedish.auth.domain.GithubUser;
import com.codesquad.sidedish.auth.domain.OAuthProperties;
import com.codesquad.sidedish.order.domain.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/github")
public class GithubAuthController extends AbstractAuthController {

    private final int EXPIRED_TIME = 86_400;

    private final GithubAuthClient authClient;
    private final AuthService authService;

    public GithubAuthController(GithubAuthClient authClient, AuthService authService,
        OAuthProperties properties) {
        super(properties.getProvider("github"));
        this.authClient = authClient;
        this.authService = authService;
    }

    @Override
    @GetMapping("/callback")
    public ResponseEntity<Void> callback(
        @RequestParam(value = "code", required = false) String code) {
        GithubToken githubToken = authClient.getToken(code);
        GithubUser githubUser = authClient.getUser(githubToken.getAccessToken());
        User user = authService.upsertUser(githubUser.toEntity());

        String accessToken = JwtFactory.create(user, EXPIRED_TIME);
        ResponseCookie cookie = ResponseCookie.from("access_token", accessToken)
            .maxAge(EXPIRED_TIME)
            .path("/")
            .build();

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .header(HttpHeaders.LOCATION, "/")
            .build();
    }

}
