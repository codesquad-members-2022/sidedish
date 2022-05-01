package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.order.UserRepository;
import com.codesquad.sidedish.order.domain.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User upsertUser(User user) {
        Optional<User> optionalUser = userRepository.findByGithubId(user.getGithubId());

        if (optionalUser.isPresent()) {
            User findUser = optionalUser.get();
            user = findUser.update(user);
        }
        userRepository.save(user);
        return user;
    }
}
