package com.example.be.controller.user;

import com.example.be.common.token.configuration.ClientRegistration;
import com.example.be.common.token.configuration.InMemoryClientRegisterrRepository;
import com.example.be.repository.member.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OauthService {

    private final InMemoryClientRegisterrRepository inMemoryClientRegisterrRepository;
    private final UserRepository userRepository;
    private static final String GITHUB = "github";

    public OauthService(InMemoryClientRegisterrRepository inMemoryClientRegisterrRepository, UserRepository userRepository) {
        this.inMemoryClientRegisterrRepository = inMemoryClientRegisterrRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ResponseEntity<String> login(String code) {
        ClientRegistration oauthProvider = inMemoryClientRegisterrRepository.findByRegistration(GITHUB);

        return null;
    }
}
