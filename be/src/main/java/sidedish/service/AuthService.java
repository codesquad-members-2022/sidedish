package sidedish.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sidedish.domain.member.Member;
import sidedish.domain.member.MemberRepository;
import sidedish.web.dto.AccessToken;
import sidedish.web.dto.ResponseDto;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService {

	@Value("${auth.client_id}")
	private String clientId;
	@Value("${auth.client_secret}")
	private String clientSecret;
	private final MemberRepository memberRepository;

	public ResponseDto userLogin(String code) {
		AccessToken accessToken = getAccessToken(code);
		log.info("log = {}", accessToken);
		Member member = getUserInfo(accessToken);
		memberRepository.save(member);
		return new ResponseDto(HttpStatus.OK, null);
	}

	private AccessToken getAccessToken(String code) {
		String url = "https://github.com/login/oauth/access_token";

		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add("Accept", "application/vnd.github.v3+json");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("code", code);

		ResponseEntity<AccessToken> response = new RestTemplate().exchange(url, HttpMethod.POST,
			new HttpEntity<>(params, header), AccessToken.class);
		return response.getBody();
	}

	private Member getUserInfo(AccessToken accessToken) {
		String url = "https://api.github.com/user";
		HttpHeaders header = new HttpHeaders();

		header.add("Accept", "application/vnd.github.v3+json");
		header.add("Authorization", "bearer " + accessToken.getAccessToken());

		ResponseEntity<Member> response = new RestTemplate().exchange(url, HttpMethod.GET,
			new HttpEntity<>(header), Member.class);
		Member body = response.getBody();
		return new Member(body.getEmail(), accessToken);
	}
}
