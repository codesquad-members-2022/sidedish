package com.codesquad.sidedish.user.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByOauthId(@Param("oauthId") String oauthId);
}
