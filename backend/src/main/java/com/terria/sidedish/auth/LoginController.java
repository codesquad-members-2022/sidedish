package com.terria.sidedish.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private String clientId = "c7a7e57a165fc7decec4";
    private String clientSecret = "";

    @GetMapping("/github/callback")
    public ResponseEntity<String> getCode(String code) {
        return ResponseEntity.ok().body(code);
    }
}
