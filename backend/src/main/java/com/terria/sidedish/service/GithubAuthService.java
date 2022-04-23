package com.terria.sidedish.service;

import com.terria.sidedish.dto.auth.GithubAccessToken;
import com.terria.sidedish.dto.auth.GithubUser;
import com.terria.sidedish.dto.auth.Provider;
import com.terria.sidedish.error.GithubOAuthException;
import com.terria.sidedish.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.terria.sidedish.error.ErrorCode.GITHUB_USER_ERROR;

@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:oauth.properties", ignoreResourceNotFound = true)
public class GithubAuthService {

    private final MemberRepository memberRepository;

    @Value("${oauth.github.clientId}")
    private String clientId;

    @Value("${oauth.github.clientSecret}")
    private String clientSecret;

    public GithubUser login(String code) {
        return requestUserInfo(requestAccessToken(code));
    }

    private GithubAccessToken requestAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/vnd.github.v3+json");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);

        ResponseEntity<GithubAccessToken> response = new RestTemplate().
                postForEntity(
                        url,
                        new HttpEntity<>(params, headers),
                        GithubAccessToken.class
                );

        return response.getBody();
    }

    private GithubUser requestUserInfo(GithubAccessToken accessToken) {
        String url = "https://api.github.com/user";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/vnd.github.v3+json");
        headers.add("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());

        ResponseEntity<GithubUser> response = new RestTemplate().
                exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        GithubUser.class
                );

        if (response.getStatusCode().isError() || response.getBody() == null) {
            throw new GithubOAuthException(GITHUB_USER_ERROR);
        }

        GithubUser githubUser = response.getBody();
        githubUser.setProvider(Provider.of(response.getHeaders().getFirst("Server")));

        return githubUser;
    }
}
