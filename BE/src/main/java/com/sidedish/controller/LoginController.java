package com.sidedish.controller;

import com.sidedish.service.AccessToken;
import com.sidedish.service.LoginService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
    public void login(HttpServletResponse response,
        @RequestParam String code, HttpSession httpSession) throws IOException {
        AccessToken accessToken = loginService.getAccessToken(code);
        List<String> userEmails = loginService.getUserEmails(accessToken);
        loginService.saveUserEmail(userEmails);

        String email = userEmails.get(0);
        httpSession.setAttribute("email", email);

        response.sendRedirect("http://localhost:3000");
    }

    @GetMapping("")
    public ResponseEntity<ResponseMessage> getEmail(HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("email");

        if (email == null) {
            ResponseMessage message = new ResponseMessage(HttpStatus.UNAUTHORIZED, "로그인이 되어있지 않습니다.");
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }

        ResponseMessage message = new ResponseMessage(HttpStatus.OK, "로그인이 정상적으로 처리되었습니다.", email);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
