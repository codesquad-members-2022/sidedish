package com.example.be.controller.user;

import com.example.be.common.token.configuration.ClientRegistration;
import com.example.be.common.token.configuration.InMemoryClientRegisterrRepository;
import com.example.be.common.token.github.GithubTokenUtils;
import com.example.be.common.token.github.GithubUser;
import com.example.be.domain.user.User;
import com.example.be.repository.member.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final InMemoryClientRegisterrRepository inMemoryClientRegisterRepository;
    private final UserRepository userRepository;
    private final GithubTokenUtils githubTokenUtils;

    private static final String GITHUB = "github";

    public ResponseEntity<String> login(String code) {
        ClientRegistration clientRegistration = inMemoryClientRegisterRepository.findByRegistration(GITHUB);
        HttpEntity<?> request = githubTokenUtils.getAccessTokenRequest(clientRegistration, code);
        GithubToken gitToken = new RestTemplate()
                .postForEntity(clientRegistration.getTokenUrl(), request, GithubToken.class)
                .getBody();

        HttpHeaders authorizationIncludedHeader = githubTokenUtils.getAuthorizationIncludedHeader(gitToken.getGithubAccessToken());
        ResponseEntity<String> response = new RestTemplate()
                .exchange(clientRegistration.getUserInfoUrl(), HttpMethod.GET, new HttpEntity<String>(authorizationIncludedHeader), String.class);
        Map<String, String> userDetail = githubTokenUtils.getUserDetail(response.getBody());
        GithubUser githubUser = GithubUser.from(userDetail);
        return null;
    }
}
