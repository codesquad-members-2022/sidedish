package com.example.be.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OauthService {

    @Transactional
    public ResponseEntity<String> login(String code) {
        return null;
    }
}
