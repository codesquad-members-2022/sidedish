package kr.codesquad.sidedish.controller;

import java.io.IOException;

import kr.codesquad.sidedish.dto.GitHubToken;
import kr.codesquad.sidedish.service.OAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OAuthController {

    private final Logger log = LoggerFactory.getLogger(OAuthController.class);
    private final OAuthService oAuthService;

    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @GetMapping("/oauth")
    public ResponseEntity<String> requestAccessToken(@RequestParam String code,
                                             HttpServletResponse httpServletResponse) throws IOException {
        GitHubToken token = oAuthService.getAccessToken(code);
        String userEmail = oAuthService.getUserEmail(token);
        String avataUrl = oAuthService.getAvataUrl(token);
        log.info("request user info, userEmail = [{}], avataUrl = [{}]", userEmail, avataUrl);
        httpServletResponse.setHeader("userEmail", userEmail);
        httpServletResponse.setHeader("avataUrl", avataUrl);

        return ResponseEntity.ok("Success");
    }


}
