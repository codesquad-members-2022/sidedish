package com.codesquad.sidedish.user.controller.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

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

        resolveToken(request)
            .ifPresent(token -> {
                int userId = Integer.parseInt(tokenProvider.getPayload(token));
                log.debug("token is : {}", token);
                log.debug("userId is : {}", userId);
                request.setAttribute("userId", userId);
            });

        return true;
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        String authorizationInfo = request.getHeader("Authorization");
        if (authorizationInfo.isEmpty()) {
            throw new RuntimeException("토큰 정보가 없으니 받아오시오");
        }

        String[] parts = authorizationInfo.split(" ");
        if (parts.length == 2 && parts[0].equals("Bearer")) {
            return Optional.ofNullable(parts[1]);
        }
        return Optional.empty();
    }
}
