package kr.codesquad.sidedish.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.codesquad.sidedish.dto.GitHubToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OAuthService {

    private final Logger log = LoggerFactory.getLogger(OAuthService.class);

    private final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    private final String GET_RESOURCE_URL = "https://api.github.com/user";
    private final String GET_EMAIL_URL = "https://api.github.com/user/emails";

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.secret}")
    private String secret;

    public GitHubToken getAccessToken(String code) {
        Map<String, String> requestBody = generateBody(code);
        RestTemplate restTemplate = new RestTemplate();
        log.info("requestbody : {}", requestBody);
        return restTemplate.postForObject(ACCESS_TOKEN_URL, requestBody,
            GitHubToken.class);
    }

    public String getUserEmail(GitHubToken token) throws JsonProcessingException {
        JsonNode jsonNode = requestResources(token, GET_EMAIL_URL);
        for (JsonNode node : jsonNode) {
            if (node.get("primary").asBoolean()) {
                log.info("email : {}", node.get("email").textValue());
                return node.get("email").textValue();
            }
        }
        return "";
    }

    public String getAvataUrl(GitHubToken token) throws JsonProcessingException {
        JsonNode jsonNode = requestResources(token, GET_RESOURCE_URL);
        String avatarUrl = jsonNode.get("avatar_url").textValue();
        log.info("avatarUrl : {}", avatarUrl);
        return avatarUrl;
    }

    private JsonNode requestResources(GitHubToken token, String url) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> request = new HttpEntity<>(headers);

        headers.set("Authorization", token.getTokenHeaderString());
        ResponseEntity<String> userResource = restTemplate.exchange(url,
                HttpMethod.GET, request, String.class);
        return objectMapper.readTree(userResource.getBody());
    }


    private Map<String, String> generateBody(String code) {
        return Map.of("client_id", clientId,
            "client_secret", secret,
            "code", code);
    }

}
