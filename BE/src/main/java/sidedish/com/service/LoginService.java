package sidedish.com.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sidedish.com.controller.model.GitHubAccessToken;

@Service
public class LoginService {
	private String clientId = "9819a665d5d8256d5ad6";
	private String clientSecret = "684aa9107cd2d757809f7fb642bab01c041a06aa";
	private String accessTokenApiUrl = "https://github.com/login/oauth/access_token";

	public void login(String code) {
		GitHubAccessToken accessToken = requestAccessToken(code);
	}

	public GitHubAccessToken requestAccessToken(String code) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);

		return new RestTemplate()
			.postForEntity(accessTokenApiUrl, new HttpEntity<>(params, headers),
				GitHubAccessToken.class).getBody();
	}
}
