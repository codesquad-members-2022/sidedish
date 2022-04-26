package com.example.be.common.service;

import com.example.be.business.user.domain.User;
import com.example.be.business.user.repository.UserRepository;
import com.example.be.common.token.TokenUtils;
import com.example.be.common.token.configuration.ClientRegistration;
import com.example.be.common.token.configuration.InMemoryClientRegisterrRepository;
import com.example.be.common.token.github.GithubToken;
import com.example.be.common.token.github.GithubTokenUtils;
import com.example.be.common.token.github.GithubUser;
import com.example.be.common.token.jwt.JwtTokenProvider;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class OauthService {

    private final InMemoryClientRegisterrRepository inMemoryClientRegisterRepository;
    private final UserRepository userRepository;
    private final FakeRedisRepository fakeRedisRepository;
    private final TokenUtils tokenUtils;
    private final JwtTokenProvider jwtTokenProvider;

    public OauthService(InMemoryClientRegisterrRepository inMemoryClientRegisterRepository, UserRepository userRepository, FakeRedisRepository fakeRedisRepository, GithubTokenUtils tokenUtils, JwtTokenProvider jwtTokenProvider) {
        this.inMemoryClientRegisterRepository = inMemoryClientRegisterRepository;
        this.userRepository = userRepository;
        this.fakeRedisRepository = fakeRedisRepository;
        this.tokenUtils = tokenUtils;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    private static final String GITHUB = "github";

    @Transactional
    public String login(String code) {
        ClientRegistration clientRegistration = inMemoryClientRegisterRepository.findByRegistration(GITHUB);
        HttpEntity<?> accessTokenRequest = tokenUtils.getAccessTokenRequest(clientRegistration, code);
        GithubToken gitToken = new RestTemplate()
                .postForEntity(clientRegistration.getTokenUrl(), accessTokenRequest, GithubToken.class)
                .getBody();

        HttpHeaders authorizationIncludedHeader = tokenUtils.getAuthorizationIncludedHeader(gitToken.getGithubAccessToken());
        ResponseEntity<String> response = new RestTemplate()
                .exchange(clientRegistration.getUserInfoUrl(), HttpMethod.GET, new HttpEntity<String>(authorizationIncludedHeader), String.class);
        Map<String, String> userDetail = tokenUtils.getUserDetail(response.getBody());
        GithubUser githubUser = GithubUser.from(userDetail);

        save(githubUser);

        String jwtToken = jwtTokenProvider.createJwtToken(githubUser.getEmail());
        fakeRedisRepository.save(jwtToken);
        return jwtToken;
    }

    // TODO 분기문 제거
    private void save(GithubUser githubUser) {
        Optional<User> findUser = userRepository.findByGithubId(githubUser.getGithubId());
        if (findUser.isPresent()) {
            findUser.get().publishUpdateEvent(githubUser.getName(), githubUser.getAvatarUrl(), githubUser.getEmail(),
                    githubUser.getLocation(), githubUser.getGithubId(), githubUser.getBio());
        } else {
            userRepository.save(new User(githubUser.getName(), null, githubUser.getAvatarUrl(), githubUser.getEmail(), githubUser.getLocation(), githubUser.getBio(), githubUser.getGithubId()));
        }
    }

}
