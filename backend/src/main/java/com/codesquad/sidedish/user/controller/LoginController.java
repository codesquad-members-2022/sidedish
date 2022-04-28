package com.codesquad.sidedish.user.controller;

import com.codesquad.sidedish.user.dto.LoginResponse;
import com.codesquad.sidedish.user.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "login", description = "로그인 API")
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "JWT 토큰 정상 반환",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class))),
            @ApiResponse(responseCode = "4xx",
                    description = "발급 중 오류 발생",
                    content = @Content)
    })
    @Operation(summary = "로그인",
            description = "code를 전달하여 OAuth 로그인을 진행하고, JWT 토큰을 발급받습니다.",
            parameters = @Parameter(name = "code",
            description = "GitHub 서버로부터 받은 code"))
    @GetMapping("/login/oauth")
    public LoginResponse githubLogin(@RequestParam("code") String code) {
        log.debug("code : {}", code);
        return loginService.login(code);
    }
}
