package com.codesquad.sidedish.user.service;

import static com.codesquad.sidedish.user.controller.interceptor.AuthenticationInterceptor.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.codesquad.sidedish.user.domain.GithubToken;
import com.codesquad.sidedish.user.domain.User;
import com.codesquad.sidedish.user.domain.UserRepository;
import com.codesquad.sidedish.user.dto.LoginResponse;
import com.codesquad.sidedish.user.dto.UserProfileDto;
import com.codesquad.sidedish.user.exception.UserInformationNotFound;

@Transactional
@Service
public class LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private final RestTemplate restTemplate = new RestTemplate();
    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final String clientId;
    private final String clientSecret;
    private final String accessTokenUri;
    private final String userInfoUri;

    public LoginService(UserRepository userRepository, JwtTokenProvider tokenProvider,
        @Value("${oauth2.user.github.client-id}") String clientId,
        @Value("${oauth2.user.github.client-secret}") String clientSecret,
        @Value("${oauth2.provider.github}") String accessTokenUri,
        @Value("${oauth2.provider.user-info-uri}") String userInfoUri) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessTokenUri = accessTokenUri;
        this.userInfoUri = userInfoUri;
    }

    public LoginResponse login(String code) {
        GithubToken token = getAccessToken(code);

        UserProfileDto userProfileDto = getUserProfile(token);

        User user = userProfileDto.toEntity(token);

        Optional<User> foundUser = userRepository.findByOauthId(user.getOauthId());

        if (foundUser.isEmpty()) {
            user = userRepository.save(user);
        }
        if (foundUser.isPresent()) {
            user = foundUser.get();
        }

        String accessToken = tokenProvider.createAccessToken(String.valueOf(user.getId()));
        return new LoginResponse("Bearer", accessToken);
    }

    private GithubToken getAccessToken(String code) {
        MultiValueMap<String, String> requestPayloads = new LinkedMultiValueMap<>();
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("client_id", clientId);
        requestPayload.put("client_secret", clientSecret);
        requestPayload.put("code", code);
        requestPayloads.setAll(requestPayload);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();

        header.put("Accept", "application/json");
        headers.setAll(header);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestPayloads, headers);

        ResponseEntity<GithubToken> response = restTemplate.postForEntity(accessTokenUri, request,
            GithubToken.class);
        return response.getBody();
    }

    private UserProfileDto getUserProfile(GithubToken token) {
        Map<String, Object> userProfileMap = getUserProfileFromOAuthServer(token)
            .orElseThrow(() -> new UserInformationNotFound("사용자 정보가 없습니다", HttpStatus.NOT_FOUND));

        return new UserProfileDto(
            String.valueOf(userProfileMap.get("id")),
            String.valueOf(userProfileMap.get("email")),
            String.valueOf(userProfileMap.get("login")));
    }

    private Optional<Map<String, Object>> getUserProfileFromOAuthServer(GithubToken token) {
        RequestEntity<Void> request = RequestEntity.get(userInfoUri)
            .header("Authorization", token.getAuthorizationValue())
            .accept(MediaType.APPLICATION_JSON)
            .build();

        ParameterizedTypeReference<HashMap<String, Object>> responseType = new ParameterizedTypeReference<>() {};

        Map<String, Object> userProfileMap = restTemplate.exchange(request, responseType).getBody();

        return Optional.ofNullable(userProfileMap);
    }
}
