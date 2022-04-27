package com.terria.sidedish.error.exception;

import com.terria.sidedish.error.ErrorCode;

public class GitHubOAuthException extends SideDishApplicationException {

    public GitHubOAuthException(ErrorCode errorCode) {
        super(errorCode);
    }
}
