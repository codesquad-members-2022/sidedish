package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sidedish.domain.member.Member;
import sidedish.domain.member.MemberRepository;
import sidedish.web.dto.AccessToken;
import sidedish.web.dto.ResponseDto;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final MemberRepository memberRepository;

	public ResponseDto userLogin(String code) {
		AccessToken accessToken = getAccessToken(code);
		Member member = getUserInfo(accessToken);
		memberRepository.save(member);
		return new ResponseDto(HttpStatus.OK, null);
	}

	private AccessToken getAccessToken(String code) {
		//code를 가지고 body만들고 ->클라아이디, 시크릿 , 코드
		//post 요청으로 github페이지에 요청 -> https://github.com/login/oauth/access_token
		//응답으로 accessToken받아서 리턴
		return null;
	}

	private Member getUserInfo(AccessToken accessToken) {
		//헤더에 Authorization : bearer accessToken
		//get요청으로 -> 유저정보 바디에서 가져와서 member에 넣고 반환
		return null;
	}
}
