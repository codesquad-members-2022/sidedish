package com.codesquad.sidedish.auth.controller;

import com.codesquad.sidedish.auth.domain.OAuthProvider;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
public class AbstractAuthController implements AuthController {

    private final OAuthProvider provider;

    @GetMapping
    public ResponseEntity<Void> login() {
        URI location = UriComponentsBuilder
            .fromPath(provider.getAuthorizePath())
            .queryParam("client_id", provider.getClientId())
            .queryParam("redirect_uri", provider.getRedirectUri())
            .build()
            .toUri();

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header(HttpHeaders.LOCATION, location.toString())
            .build();
    }

    @Override
    @GetMapping("/callback")
    public ResponseEntity<Void> callback(String code) {
        throw new IllegalStateException("oauth callback not supported");
    }
}
