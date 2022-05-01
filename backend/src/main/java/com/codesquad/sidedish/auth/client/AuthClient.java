package com.codesquad.sidedish.auth.client;

public interface AuthClient<T, U> {

    T getToken(String code);

    U getUser(String accessToken);
}
