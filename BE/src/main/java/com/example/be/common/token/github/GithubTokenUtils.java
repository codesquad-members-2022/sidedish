package com.example.be.common.token.github;

import com.example.be.common.token.TokenUtils;
import com.example.be.common.token.configuration.ClientRegistration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 *
 */
@Component
public class GithubTokenUtils implements TokenUtils {

    private static final String CLIENT_ID = "client_id";
    private static final String CLIENT_SECRET = "client_secret";
    private static final String CODE = "code";

    private GithubTokenParser githubTokenParser;

    private GithubTokenUtils(GithubTokenParser githubTokenParser) {
        this.githubTokenParser = githubTokenParser;
    }

    @Override
    public HttpEntity<?> getAccessTokenRequest(ClientRegistration clientRegistration, String code) {
        Assert.notNull(clientRegistration, "Registration must be not null.");
        Assert.notNull(code, "Code must be not null.");
        MultiValueMap<String, String> headers = getHeadder();
        MultiValueMap<String, String> payLoad = getPayLoad(clientRegistration, code);
        return new HttpEntity<>(payLoad, headers);
    }

    @Override
    public MultiValueMap<String, String> getHeadder() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        return headers;
    }

    @Override
    public MultiValueMap<String, String> getPayLoad(ClientRegistration clientRegistration, String code) {
        MultiValueMap<String, String> payLoad = new LinkedMultiValueMap<>();
        payLoad.set(CLIENT_ID, clientRegistration.getClientId());
        payLoad.set(CLIENT_SECRET, clientRegistration.getClientSecret());
        payLoad.set(CODE, code);
        return payLoad;
    }

    @Override
    public HttpHeaders getAuthorizationIncludedHeader(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AUTHORIZATION, accessToken);
        return headers;
    }

    /**
     * 처음엔 Http, RestTemplate과 같은 외부와 연결되는 포인트 때문에
     * 클래스 내부에 메서드를 두는 것에 고민이 많았으나 Github Token 자체가
     * 웹과 연관되어 있고, 해당 서버로 요청을 보내는 작업이 많다고 판단해서
     * 클래스 내부로 메서드 이동. 또한 GithubTokenUtil은 구현체이기 때문에
     * 큰 상관 없을 것으로 판단.
     */
    @Override
    public Map<String, String> getUserDetailFrom(ClientRegistration clientRegistration, GithubToken gitToken) {
        Assert.notNull(clientRegistration, "Registration must be not null.");
        Assert.notNull(gitToken, "Token must be not null.");
        HttpHeaders authorizationIncludedHeader = getAuthorizationIncludedHeader(gitToken.getGithubAccessToken());
        ResponseEntity<String> response = new RestTemplate()
                .exchange(clientRegistration.getUserInfoUrl(), HttpMethod.GET,
                        new HttpEntity<String>(authorizationIncludedHeader), String.class);
        return getUserDetail(response.getBody());
    }

    @Override
    public Map<String, String> getUserDetail(String userInformationCode) {
        return githubTokenParser.getUserInformation(userInformationCode);
    }

}
