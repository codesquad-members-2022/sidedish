package com.example.be.controller.user;

import com.example.be.common.token.jwt.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private static final long EXPIRE = 60 * 1000;

    @Value("${oauth.token.secret}")
    private String secretKey;

    private long tokenValidationSeconds;

    public JwtTokenProvider(String secretKey, long tokenValidationSeconds) {
        this.secretKey = secretKey;
        this.tokenValidationSeconds = tokenValidationSeconds;
    }

    public JwtTokenProvider() {
    }

    private Key getSigninKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String createJwtToken(String email) {
        JwtToken jwtToken = new JwtToken(email);
        Claims claims = Jwts.claims();
        claims.put("email", jwtToken.getClaim("email"));
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (60 * 1000)))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public JwtToken getToken(String token) {
        Claims body = getClaims(token);
        String email = body.get("email", String.class);
        return new JwtToken(email);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
