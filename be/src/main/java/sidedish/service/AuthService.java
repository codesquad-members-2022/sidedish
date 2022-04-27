package sidedish.service;

import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
		Member member = getUserInfo(accessToken);
		memberRepository.save(member);
		return new ResponseDto(HttpStatus.OK, null);
	}

	private AccessToken getAccessToken(String code) {
		//code를 가지고 body만들고 ->클라아이디, 시크릿 , 코드
		String url = "https://github.com/login/oauth/access_token";
		//post 요청으로 github페이지에 요청 -> https://github.com/login/oauth/access_token
		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/vnd.github.v3+json");
		Map<String, String> params = new HashMap<>();
		params.put("client_id", clientId);
		params.put("client_secret", clientSecret);
		params.put("code", code);
		//응답으로 accessToken받아서 리턴
		ResponseEntity<AccessToken> response = new RestTemplate().exchange(url, HttpMethod.POST,
			new HttpEntity<>(params, header), AccessToken.class);

		log.info("log = {}", response.getBody());
		return response.getBody();
	}

	private Member getUserInfo(AccessToken accessToken) {
		//헤더에 Authorization : bearer accessToken
		//get요청으로 -> 유저정보 바디에서 가져와서 member에 넣고 반환
		return null;
	}
}
