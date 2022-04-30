package com.team35.sidedish.error.exception;

import com.team35.sidedish.error.ErrorCode;

public class GitHubOAuthException extends SideDishApplicationException {

    public GitHubOAuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
