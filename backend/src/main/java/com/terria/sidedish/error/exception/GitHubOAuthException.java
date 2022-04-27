package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GitHubOAuthException extends RuntimeException {

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
