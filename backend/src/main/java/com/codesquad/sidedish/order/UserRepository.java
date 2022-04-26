package com.codesquad.sidedish.order;

import com.codesquad.sidedish.order.domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByGithubId(String githubId);
}
