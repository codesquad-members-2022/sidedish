package com.terria.sidedish.auth;

import com.terria.sidedish.dto.auth.GithubUser;
import com.terria.sidedish.service.GithubAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final GithubAuthService loginService;

    @GetMapping("/github/callback")
    public GithubUser login(String code) {
        return loginService.login(code);
    }
}
