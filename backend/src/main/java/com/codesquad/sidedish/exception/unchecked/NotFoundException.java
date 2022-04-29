package com.codesquad.sidedish.exception.unchecked;

import com.codesquad.sidedish.exception.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
