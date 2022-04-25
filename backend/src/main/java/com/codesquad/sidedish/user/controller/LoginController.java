package com.codesquad.sidedish.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesquad.sidedish.user.dto.LoginResponse;
import com.codesquad.sidedish.user.service.LoginService;

@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/oauth")
    public LoginResponse githubLogin(@RequestParam("code") String code) {
        log.debug("code : {}", code);
        return loginService.login(code);
    }

    @GetMapping("/testapi")
    public String testApi(HttpServletRequest request) {
        Integer userId = (Integer)request.getAttribute("userId");
        log.debug("userId is {}", userId);
        return String.valueOf(userId);
    }
}
