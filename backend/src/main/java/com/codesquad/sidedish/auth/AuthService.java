package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.order.UserRepository;
import com.codesquad.sidedish.order.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User upsertUser(String githubId, String username) {
        User user = userRepository.findByGithubId(githubId)
            .orElseGet(User::new);
        user.update(githubId, username);
        userRepository.save(user);
        return user;
    }
}
