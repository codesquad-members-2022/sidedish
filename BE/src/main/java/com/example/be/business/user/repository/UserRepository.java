package com.example.be.business.user.repository;

import com.example.be.business.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByGithubId(String githubId);
//    Optional<User> findByGithubId(String email);
}
