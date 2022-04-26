package com.example.be.common.login.controller;

import com.example.be.controller.user.OauthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/oauth")
public class OauthController {

    private OauthService oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/login/oauth/{provider}")
    public ResponseEntity<String> login(@PathVariable String provider, @RequestParam String code) {
        return oauthService.login(code);
    }
}
