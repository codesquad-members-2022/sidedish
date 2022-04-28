package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.order.UserRepository;
import com.codesquad.sidedish.order.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginFilter implements Filter {

    private final UserRepository userRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String authorizationHeader = req.getHeader(HttpHeaders.AUTHORIZATION);

        tokenValidationCheck(authorizationHeader);
        String token = authorizationHeader.substring("Bearer ".length());

        try {
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(JwtFactory.key)
                .build()
                .parseClaimsJws(token)
                .getBody();

            userIdValidationCheck(request, response, chain, res, claims);
            expiredValidationCheck(request, response, chain, res, claims);

        } catch (JwtException e) {

            //don't trust the JWT!
            redirectLogin(request, response, chain, res);
        }
    }

    private void userIdValidationCheck(ServletRequest request, ServletResponse response, FilterChain chain,
        HttpServletResponse res, Claims claims) throws IOException, ServletException {
        String userId = (String) claims.get("userId");
        Optional<User> optionalUser = userRepository.findByGithubId(userId);

        if (optionalUser.isEmpty()) {
            redirectLogin(request, response, chain, res);
        }
    }

    private void expiredValidationCheck(ServletRequest request, ServletResponse response, FilterChain chain,
        HttpServletResponse res, Claims claims) throws IOException, ServletException {
        long exp = ((Integer) claims.get("exp")).longValue();
        long now = new Date().getTime();
        if (now < exp){
            redirectLogin(request, response, chain, res);
        }
    }

    private void redirectLogin(ServletRequest request, ServletResponse response, FilterChain chain,
        HttpServletResponse res) throws IOException, ServletException {
        res.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        res.setHeader(HttpHeaders.LOCATION, "/login");
        chain.doFilter(request, response);
    }

    private void tokenValidationCheck(String authorizationHeader) {
        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")){
            throw new IllegalArgumentException("token validation check: fail");
        }
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
