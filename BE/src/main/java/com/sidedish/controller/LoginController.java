package com.sidedish.controller;

import com.sidedish.service.AccessToken;
import com.sidedish.service.LoginService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class LoginController {

    private final LoginService loginService;

    //Todo
    @GetMapping("github-login")
    public ResponseEntity login(@RequestParam String code, HttpSession httpSession) {
        String email = loginService.getUserEmail(code);
        System.out.println("email:" + email);
        httpSession.setAttribute("email", email);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
