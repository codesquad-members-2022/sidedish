package sidedish.jbc.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import sidedish.jbc.domain.OauthDto;

@Controller
public class OAuthController {

	private static final String REDIRECT_GITHUB_URL =
		"https://github.com/login/oauth/authorize?client_id=" + System.getenv("CLIENT_ID")
			+ "&redirect_uri=http://localhost:8080/afterlogin";
	private static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";

	@GetMapping("/login")
	public ResponseEntity<Object> login() throws URISyntaxException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(new URI(REDIRECT_GITHUB_URL));
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}

	@GetMapping("/afterlogin")
	public ResponseEntity<String> afterLogin(@RequestParam String code, HttpSession session)
		throws URISyntaxException {

		if (Objects.isNull(code)) {
			throw new IllegalStateException("Github 로그인이 실패했습니다.");
		}

		RestTemplate restTemplate = new RestTemplate();
		OauthDto oauthDto = new OauthDto(code, System.getenv("CLIENT_ID"),
			System.getenv("SECRET_CODE"));
		String queryParam = restTemplate.postForObject(GITHUB_ACCESS_TOKEN_URL, oauthDto,
			String.class);

		if (queryParam.contains("error")) {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(new URI(REDIRECT_GITHUB_URL));
			return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		}

		String accessToken = extractAccessToken(queryParam);
		session.setAttribute("accessToken", accessToken);

		System.out.println(accessToken);

		return ResponseEntity.ok().build();
	}

	private String extractAccessToken(String queryParam) {
		return queryParam.split("&")[0].split("=")[1];
	}

}
