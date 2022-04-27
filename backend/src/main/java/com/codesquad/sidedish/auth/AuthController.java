package com.codesquad.sidedish.auth;


import com.codesquad.sidedish.order.UserRepository;
import com.codesquad.sidedish.order.domain.User;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
@PropertySource("classpath:oauth.properties")
public class AuthController {

    private final UserRepository userRepository;
    @Value("${oauth.client_id}")
    private String clientId;
    @Value("${oauth.client_secret}")
    private String clientSecret;
    @Value("${oauth.redirect_uri}")
    private String redirectUri;

    @GetMapping("/auth/github")
    public ResponseEntity<Void> githubLogin() {
        String stringBuilder = String.format(
            "https://github.com/login/oauth/authorize?clientId=%s&redirect_uri=%s",
            clientId, clientSecret);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create(stringBuilder));
        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/callback")
    public void githubCallback(@RequestParam(value = "code", required = false) String code) {

        System.out.println("code = " + code);

        TokenResponse token = WebClient.create()
            .post()
            .uri(URI.create("https://github.com/login/oauth/access_token"))
            .headers(headers -> {
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                headers.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
            })
            .bodyValue(tokenRequest(code))
            .retrieve()
            .bodyToMono(TokenResponse.class)
            .block();

        System.out.println("token = " + token);

        if (token == null) {
            throw new IllegalStateException();
        }

        Map<String, String> userAttributes = WebClient.create()
            .get()
            .uri(URI.create("https://api.github.com/user"))
            .header("Accept", "application/vnd.github.v3+json")
            .header("Authorization", "token " + token.getAccessToken())
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
            })
            .block();

        if (userAttributes == null) {
            throw new IllegalStateException();
        }

        UserResponse response = new UserResponse(
            userAttributes.get("login"),
            userAttributes.get("name")
        );

        System.out.println("response = " + response);

        User user = userRepository.findByGithubId(response.getGithubId())
            .orElseGet(User::new);
        user.update(response.getGithubId(), response.getUsername());
        userRepository.save(user);

        // TODO: JWT 발급 후 브라우저의 쿠키에 저장될 수 있도록 구현
    }

    private MultiValueMap<String, String> tokenRequest(String code) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("client_id", clientId);
        multiValueMap.add("client_secret", clientSecret);
        multiValueMap.add("code", code);
        return multiValueMap;
    }
}
