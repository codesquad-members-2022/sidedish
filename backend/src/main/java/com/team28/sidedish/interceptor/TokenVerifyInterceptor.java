package com.team28.sidedish.interceptor;

import com.team28.sidedish.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenVerifyInterceptor implements HandlerInterceptor {

    private static final String token = "token";
    private static final String githubOAuthLoginUrl = "/auth/github";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwtToken = request.getHeader(token);

        if (isTokenEmpty(jwtToken) || !JwtUtils.isValidToken(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.sendRedirect(githubOAuthLoginUrl);

            return false;
        }

        return true;
    }

    private boolean isTokenEmpty(String jwtToken) {
        return jwtToken == null || jwtToken.isEmpty();
    }
}
