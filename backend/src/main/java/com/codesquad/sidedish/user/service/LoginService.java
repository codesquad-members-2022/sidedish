package com.codesquad.sidedish.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.codesquad.sidedish.user.domain.GithubToken;
import com.codesquad.sidedish.user.domain.User;
import com.codesquad.sidedish.user.domain.UserRepository;
import com.codesquad.sidedish.user.dto.LoginResponse;
import com.codesquad.sidedish.user.dto.UserProfileDto;
import com.codesquad.sidedish.user.exception.GlobalException;

@Service
public class LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;

    public LoginService(UserRepository userRepository, JwtTokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
    }

    @Value("${oauth2.user.github.client-id}")
    private String clientId;

    @Value("${oauth2.user.github.client-secret}")
    private String clientSecret;

    @Value("${oauth2.provider.github}")
    private String accessTokenUri;

    @Value("${oauth2.provider.user-info-uri}")
    private String userInfoUri;

    public LoginResponse login(String code) {
        GithubToken token = getAccessToken(code);

        // 유저 정보 가져오기
        UserProfileDto userProfileDto = getUserProfile(token);

        // 정보 기반으로 User 만들기
        User user = new User(userProfileDto.getOauthId(), userProfileDto.getName(), userProfileDto.getEmail());

        // 저장하기
        User savedUser = userRepository.save(user);

        // 토큰 발행하기
        String accessToken = tokenProvider.createAccessToken(String.valueOf(savedUser.getId()));

        // 반환하기
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

        ResponseEntity<GithubToken> response = new RestTemplate().postForEntity(accessTokenUri, request,
            GithubToken.class);
        return response.getBody();
    }

    private UserProfileDto getUserProfile(GithubToken token) {
        Map<String, Object> userProfileMap = getUserProfileFromOAuthServer(token)
            .orElseThrow(GlobalException::new);

        return new UserProfileDto(
            String.valueOf(userProfileMap.get("id")),
            (String)userProfileMap.get("email"),
            (String)userProfileMap.get("login"));
    }

    private Optional<Map<String, Object>> getUserProfileFromOAuthServer(GithubToken token) {
        RequestEntity<Void> request = RequestEntity.get(userInfoUri)
            .header("Authorization", token.getAuthorizationValue())
            .accept(MediaType.APPLICATION_JSON)
            .build();

        ParameterizedTypeReference<HashMap<String, Object>> responseType = new ParameterizedTypeReference<>() {};

        Map<String, Object> userProfileMap = new RestTemplate().exchange(request, responseType).getBody();

        return Optional.ofNullable(userProfileMap);
    }
}
