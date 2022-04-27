package com.codesquad.sidedish.user.domain;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT U.ID, U.OAUTH_ID, U.USERNAME, U.EMAIL, U.ACCESS_TOKEN, U.TOKEN_TYPE, U.SCOPE FROM user U WHERE U.OAUTH_ID = :oauth_id")
    Optional<User> findByOAuthId(@Param("oauth_id") String oauthId);
}
