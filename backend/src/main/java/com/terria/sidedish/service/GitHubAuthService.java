package com.terria.sidedish.service;

import com.terria.sidedish.domain.Member;
import com.terria.sidedish.dto.auth.GitHubAccessToken;
import com.terria.sidedish.dto.auth.GitHubUser;
import com.terria.sidedish.dto.auth.Provider;
import com.terria.sidedish.dto.response.MemberResponse;
import com.terria.sidedish.error.exception.GitHubOAuthException;
import com.terria.sidedish.error.exception.OAuthException;
import com.terria.sidedish.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.terria.sidedish.error.ErrorCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:oauth.properties", ignoreResourceNotFound = true)
public class GitHubAuthService {

    private final MemberRepository memberRepository;

    @Value("${oauth.github.clientId}")
    private String clientId;

    @Value("${oauth.github.clientSecret}")
    private String clientSecret;

    public MemberResponse login(String code) {
        GitHubAccessToken gitHubAccessToken = requestAccessToken(code);
        GitHubUser gitHubUser = requestUserInfo(gitHubAccessToken);

        String userId = gitHubUser.getUserId();
        Provider provider = Provider.of(gitHubUser.getProvider());

        Member member = gitHubUser.toEntity();

        if (!memberRepository.existsByUserIdAndProvider(userId, provider)) {
            memberRepository.save(member);
        }

        log.info("Member: {}", memberRepository.findByUserIdAndProvider(userId, provider)
                .orElseThrow(() -> new OAuthException(NO_SUCH_MEMBER_ERROR)));

        return MemberResponse.from(member);
    }

    private GitHubAccessToken requestAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/vnd.github.v3+json");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);

        ResponseEntity<GitHubAccessToken> response = new RestTemplate().
                postForEntity(
                        url,
                        new HttpEntity<>(params, headers),
                        GitHubAccessToken.class
                );

        return response.getBody();
    }

    private GitHubUser requestUserInfo(GitHubAccessToken accessToken) {
        String url = "https://api.github.com/user";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/vnd.github.v3+json");
        headers.add("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());

        ResponseEntity<GitHubUser> response = new RestTemplate().
                exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        GitHubUser.class
                );

        if (response.getStatusCode().isError() || response.getBody() == null) {
            throw new GitHubOAuthException(EXHIBITION_VALIDATION_ERROR);
        }

        GitHubUser gitHubUser = response.getBody();
        gitHubUser.setProvider(response.getHeaders().getFirst("Server"));
        gitHubUser.setAccessToken(accessToken);

        return gitHubUser;
    }
}
