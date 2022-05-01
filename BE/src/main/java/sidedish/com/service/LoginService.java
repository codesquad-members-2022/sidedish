package sidedish.com.service;

import static sidedish.com.config.GitHubOAuthUtils.*;

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
			.exchange(USER_API_URL, HttpMethod.GET,
				new HttpEntity<>(httpHeaders), User.class).getBody();
		user.setAccessToken(accessToken);
		return user;
	}

	public GitHubAccessToken requestAccessToken(String code) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", CLIENT_ID);
		params.add("client_secret", CLIENT_SECRET);

		return new RestTemplate()
			.postForEntity(ACCESSTOKEN_API_URL, new HttpEntity<>(params, headers),
				GitHubAccessToken.class).getBody();
	}
}
