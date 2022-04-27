package kr.codesquad.sidedish.controller;

import java.io.IOException;

import kr.codesquad.sidedish.dto.GitHubToken;
import kr.codesquad.sidedish.service.OAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OAuthController {

    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @GetMapping("/oauth")
    public ResponseEntity<String> requestAccessToken(@RequestParam String code,
        HttpServletResponse httpServletResponse) throws IOException {
        GitHubToken token = oAuthService.getAccessToken(code);
        String userEmail = oAuthService.getUserEmail(token);
        httpServletResponse.setHeader("userEmail", userEmail);
        System.out.println("userEmail = " + userEmail);
        return ResponseEntity.ok("success");
    }


}
