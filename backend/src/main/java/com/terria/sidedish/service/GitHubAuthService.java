package com.terria.sidedish.service;

import com.terria.sidedish.domain.Member;
import com.terria.sidedish.dto.auth.GitHubAccessToken;
import com.terria.sidedish.dto.auth.GitHubUser;
import com.terria.sidedish.dto.auth.OAuthAdapter;
import com.terria.sidedish.dto.auth.Provider;
import com.terria.sidedish.dto.response.MemberResponse;
import com.terria.sidedish.error.exception.OAuthException;
import com.terria.sidedish.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import static com.terria.sidedish.error.ErrorCode.*;

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
