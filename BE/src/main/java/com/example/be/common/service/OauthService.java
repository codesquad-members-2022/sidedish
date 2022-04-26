package com.example.be.common.service;

import com.example.be.business.user.repository.UserRepository;
import com.example.be.common.token.configuration.ClientRegistration;
import com.example.be.common.token.configuration.InMemoryClientRegisterrRepository;
import com.example.be.common.token.github.GithubToken;
import com.example.be.common.token.github.GithubTokenUtils;
import com.example.be.common.token.github.GithubUser;
import com.example.be.common.token.jwt.JwtToken;
import com.example.be.common.token.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OauthService {

    private final InMemoryClientRegisterrRepository inMemoryClientRegisterRepository;
    private final UserRepository userRepository;
    private final GithubTokenUtils githubTokenUtils;
    private final JwtTokenProvider jwtTokenProvider;

    public OauthService(InMemoryClientRegisterrRepository inMemoryClientRegisterRepository, UserRepository userRepository, GithubTokenUtils githubTokenUtils, JwtTokenProvider jwtTokenProvider) {
        this.inMemoryClientRegisterRepository = inMemoryClientRegisterRepository;
        this.userRepository = userRepository;
        this.githubTokenUtils = githubTokenUtils;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    private static final String GITHUB = "github";

    @Transactional
    public String login(String code) {
        ClientRegistration clientRegistration = inMemoryClientRegisterRepository.findByRegistration(GITHUB);
        HttpEntity<?> accessTokenRequest = githubTokenUtils.getAccessTokenRequest(clientRegistration, code);
        GithubToken gitToken = new RestTemplate()
                .postForEntity(clientRegistration.getTokenUrl(), accessTokenRequest, GithubToken.class)
                .getBody();

        HttpHeaders authorizationIncludedHeader = githubTokenUtils.getAuthorizationIncludedHeader(gitToken.getGithubAccessToken());
        ResponseEntity<String> response = new RestTemplate()
                .exchange(clientRegistration.getUserInfoUrl(), HttpMethod.GET, new HttpEntity<String>(authorizationIncludedHeader), String.class);
        Map<String, String> userDetail = githubTokenUtils.getUserDetail(response.getBody());
        GithubUser githubUser = GithubUser.from(userDetail);
        return jwtTokenProvider.createJwtToken(githubUser.getEmail());
    }
}
