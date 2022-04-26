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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

import static com.example.be.common.token.github.GithubToken.GITHUB;

@Service
public class OauthService {

    private final Logger logger = LoggerFactory.getLogger(OauthService.class);
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

    @Transactional
    public String login(String code) {
        ClientRegistration clientRegistration = inMemoryClientRegisterRepository.findByRegistration(GITHUB);
        HttpEntity<?> accessTokenRequest = tokenUtils.getAccessTokenRequest(clientRegistration, code);
        GithubToken gitToken = new RestTemplate()
                .postForEntity(clientRegistration.getTokenUrl(), accessTokenRequest, GithubToken.class)
                .getBody();

        Map<String, String> userDetail = tokenUtils.getUserDetailFrom(clientRegistration, gitToken);

        GithubUser githubUser = GithubUser.from(userDetail);
        String jwtToken = jwtTokenProvider.createJwtToken(githubUser.getGithubId());

        save(githubUser, jwtToken);
        logger.info("토큰 발급: {}", jwtToken);
        return jwtToken;
    }

    // TODO 분기문 제거
    private void save(GithubUser githubUser, String jwtToken) {
        logger.info("사용자 및 토큰 저장 {}, {}", githubUser.getGithubId(), jwtToken);
        Optional<User> findUser = userRepository.findByGithubId(githubUser.getGithubId());
        if (findUser.isPresent()) {
            findUser.get().publishUpdateEvent(githubUser.getName(), githubUser.getAvatarUrl(), githubUser.getEmail(),
                    githubUser.getLocation(), githubUser.getGithubId(), githubUser.getBio());
        } else {
            userRepository.save(new User(githubUser.getName(), null, githubUser.getAvatarUrl(), githubUser.getEmail(), githubUser.getLocation(), githubUser.getBio(), githubUser.getGithubId()));
        }
        fakeRedisRepository.save(jwtToken);
    }
}
