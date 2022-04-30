package com.team35.sidedish.domain.entity.aggregate;

import com.team35.sidedish.dto.auth.GitHubAccessToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccessToken {

    private String accessToken;
    private String tokenType;
    private String scope;

    public static AccessToken of(GitHubAccessToken gitHubAccessToken) {
        return new AccessToken(
                gitHubAccessToken.getAccessToken(),
                gitHubAccessToken.getTokenType(),
                gitHubAccessToken.getScope()
        );
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
