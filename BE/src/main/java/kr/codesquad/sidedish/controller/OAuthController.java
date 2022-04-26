package kr.codesquad.sidedish.controller;

import java.io.IOException;

import kr.codesquad.sidedish.dto.GitHubToken;
import kr.codesquad.sidedish.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;

@RestController
public class OAuthController {

    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @GetMapping("/oauth")
    public ResponseEntity<String> requestAccessToken(@RequestParam String code, HttpServletResponse httpServletResponse) throws IOException {
        GitHubToken token = oAuthService.getAccessToken(code);
        String userEmail = oAuthService.getUserEmail(token);
        httpServletResponse.setHeader("userEmail", userEmail);
        httpServletResponse.sendRedirect("localhost:8080");
        return new ResponseEntity<>(HttpStatus.TEMPORARY_REDIRECT);

    }

}