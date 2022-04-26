package sidedish.jbc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import sidedish.jbc.domain.OauthDto;

@Controller
public class OAuthController {

	@GetMapping("/afterlogin")
	public ResponseEntity<String> afterLogin(@RequestParam String code, HttpServletRequest request) {
		if (Objects.isNull(code)) {
			throw new IllegalStateException("Github 로그인이 실패했습니다.");
		}
		RestTemplate restTemplate = new RestTemplate();
		OauthDto oauthDto = new OauthDto();
		oauthDto.setCode(code);
		oauthDto.setClient_id(System.getenv("CLIENT_ID"));
		oauthDto.setClient_secret(System.getenv("SECRET_CODE"));
		String accessToken = restTemplate.postForObject("https://github.com/login/oauth/access_token", oauthDto, String.class);
		if (accessToken.contains("error")) {
			//로그인 실패

			// 리다이렉트

		}
		// 로그인 성공

		System.out.println(accessToken);

		return ResponseEntity.ok().build();
	}

}
