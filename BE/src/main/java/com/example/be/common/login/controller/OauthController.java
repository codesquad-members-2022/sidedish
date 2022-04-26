package com.example.be.common.login.controller;

import com.example.be.common.login.controller.dto.LoginResponse;
import com.example.be.common.service.OauthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class OauthController {

    private OauthService oauthService;

    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/api/login/oauth/github")
    public ResponseEntity<LoginResponse> login(@RequestParam String code) {
        return new ResponseEntity<>(new LoginResponse(oauthService.login(code)), HttpStatus.OK);
    }
}
