package com.terria.sidedish.dto.auth;

import com.terria.sidedish.error.exception.GitHubOAuthException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.terria.sidedish.error.ErrorCode.EXHIBITION_VALIDATION_ERROR;

public interface OAuthAdapter {

    String GITHUB_V3_JSON = "application/vnd.github.v3+json";

    default GitHubAccessToken requestAccessToken(String clientId, String clientSecret, String code) {
        String url = "https://github.com/login/oauth/access_token";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", GITHUB_V3_JSON);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);

        ResponseEntity<GitHubAccessToken> response = new RestTemplate()
                .postForEntity(url, new HttpEntity<>(params, headers), GitHubAccessToken.class);

        return response.getBody();
    }

    default GitHubUser requestUserInfo(GitHubAccessToken accessToken) {
        String url = "https://api.github.com/user";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", GITHUB_V3_JSON);
        headers.add("Authorization", accessToken.getTokenType() + " " + accessToken.getAccessToken());

        ResponseEntity<GitHubUser> response = new RestTemplate()
                .exchange(url, HttpMethod.GET, new HttpEntity<>(headers), GitHubUser.class);

        if (response.getStatusCode().isError() || response.getBody() == null) {
            throw new GitHubOAuthException(EXHIBITION_VALIDATION_ERROR);
        }

        GitHubUser gitHubUser = response.getBody();
        gitHubUser.setProvider(response.getHeaders().getFirst("Server"));
        gitHubUser.setAccessToken(accessToken);

        return gitHubUser;
    }
}
