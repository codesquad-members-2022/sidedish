package sidedish.com.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sidedish.com.controller.DomainDtoMapper;
import sidedish.com.controller.model.UserResponse;
import sidedish.com.domain.GitHubAccessToken;
import sidedish.com.domain.User;
import sidedish.com.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class LoginService {

	private final DomainDtoMapper domainDtoMapper;
	private final UserRepository userRepository;
	private String clientId = "9819a665d5d8256d5ad6";
	private String clientSecret = "684aa9107cd2d757809f7fb642bab01c041a06aa";
	private String accessTokenApiUrl = "https://github.com/login/oauth/access_token";

	public UserResponse login(String code) {
		GitHubAccessToken accessToken = requestAccessToken(code);
		User user = requestUser(accessToken);
		User saveUser = userRepository.save(user);
		return domainDtoMapper.toUserResponseFromUser(saveUser);
	}

	private User requestUser(GitHubAccessToken accessToken) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
		httpHeaders.setBearerAuth(accessToken.getAccessToken());

		User user = new RestTemplate()
			.exchange("https://api.github.com/user", HttpMethod.GET,
				new HttpEntity<>(httpHeaders), User.class).getBody();
		user.setAccessToken(accessToken);
		return user;
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
