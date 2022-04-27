package com.codesquad.sidedish.user.controller.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.codesquad.sidedish.user.exception.NoTokenException;
import com.codesquad.sidedish.user.service.JwtTokenProvider;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    private final JwtTokenProvider tokenProvider;

    public AuthenticationInterceptor(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
        Exception {

        Optional<String> token = resolveToken(request);
        if (token.isPresent()) {
            int userId = Integer.parseInt(tokenProvider.getPayload(token.get()));
            log.debug("token is : {}", token);
            log.debug("userId is : {}", userId);
            request.setAttribute("userId", userId);
            return true;
        }
        throw new NoTokenException("토큰이 없습니다. 로그인 먼저 해주세요.", HttpStatus.UNAUTHORIZED);
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        String authorizationInfo = request.getHeader("Authorization");
        if (authorizationInfo == null) {
            return Optional.empty();
        }
        String[] parts = authorizationInfo.split(" ");
        if (parts.length == 2 && parts[0].equals("Bearer")) {
            return Optional.ofNullable(parts[1]);
        }
        return Optional.empty();
    }
}
