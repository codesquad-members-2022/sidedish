package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.auth.dto.UserResponse;
import com.codesquad.sidedish.order.UserRepository;
import com.codesquad.sidedish.order.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User upsertUser(UserResponse response) {
        User user = userRepository.findByGithubId(response.getGithubId())
            .orElseGet(User::new);
        user.update(response.getGithubId(), response.getUsername());
        userRepository.save(user);
        return user;
    }
}
