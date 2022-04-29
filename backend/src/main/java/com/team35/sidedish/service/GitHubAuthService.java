package com.team35.sidedish.service;

import com.team35.sidedish.dto.auth.GitHubAccessToken;
import com.team35.sidedish.dto.auth.GitHubUser;
import com.team35.sidedish.dto.auth.OAuthAdapter;
import com.team35.sidedish.dto.auth.Provider;
import com.team35.sidedish.dto.response.MemberResponse;
import com.team35.sidedish.error.exception.OAuthException;
import com.team35.sidedish.repository.MemberRepository;
import com.team35.sidedish.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import static com.team35.sidedish.error.ErrorCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource(value = "classpath:oauth.properties", ignoreResourceNotFound = true)
public class GitHubAuthService implements OAuthAdapter {

    private final MemberRepository memberRepository;

    @Value("${oauth.github.clientId}")
    private String clientId;

    @Value("${oauth.github.clientSecret}")
    private String clientSecret;

    public MemberResponse login(String code) {
        GitHubAccessToken gitHubAccessToken = requestAccessToken(clientId, clientSecret, code);
        GitHubUser gitHubUser = requestUserInfo(gitHubAccessToken);

        String userId = gitHubUser.getUserId();
        Provider provider = Provider.of(gitHubUser.getProvider());

        Member member = gitHubUser.toEntity();

        if (!memberRepository.existsByUserIdAndProvider(userId, provider)) {
            memberRepository.save(member);
        }

        Member newMember = memberRepository.findByUserIdAndProvider(userId, provider)
                .orElseThrow(() -> new OAuthException(NO_SUCH_MEMBER_ERROR));

        log.info("Member: {}", newMember);

        return MemberResponse.from(member);
    }
}
