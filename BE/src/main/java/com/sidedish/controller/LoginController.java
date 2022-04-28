package com.sidedish.controller;

import com.sidedish.service.AccessToken;
import com.sidedish.service.LoginService;
import java.util.List;
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
@RequestMapping(value = "api", produces = "application/json; charset=utf8")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("github-login")
    public ResponseEntity login(@RequestParam String code, HttpSession httpSession) {
        AccessToken accessToken = loginService.getAccessToken(code);
        List<String> userEmails = loginService.getUserEmails(accessToken);
        loginService.saveUserEmail(userEmails);

        String publicEmail = userEmails.get(0);
        httpSession.setAttribute("email", publicEmail);

        ResponseMessage message = new ResponseMessage(HttpStatus.OK, "로그인이 정상적으로 처리되었습니다.", publicEmail);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
