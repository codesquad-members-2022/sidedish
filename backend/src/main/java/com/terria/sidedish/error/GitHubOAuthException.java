package com.terria.sidedish.error;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GitHubOAuthException extends RuntimeException {

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
