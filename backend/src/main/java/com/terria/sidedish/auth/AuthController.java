package com.terria.sidedish.auth;

import com.terria.sidedish.dto.response.MemberResponse;
import com.terria.sidedish.service.GitHubAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final GitHubAuthService loginService;

    @GetMapping("/github/callback")
    public MemberResponse login(String code) {
        return loginService.login(code);
    }
}
