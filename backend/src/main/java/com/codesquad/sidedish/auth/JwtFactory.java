package com.codesquad.sidedish.auth;

import com.codesquad.sidedish.order.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtFactory {

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String create(User user, int expiredTime) {
        // https://github.com/jwtk/jjwt#quickstart
        Date now = new Date();
        return Jwts.builder()
            .setHeader(createJwtHeader())
            .setClaims(createJwtClaims(user))
            .setExpiration(new Date(now.getTime() + expiredTime))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    private static Map<String, Object> createJwtHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private static Map<String, Object> createJwtClaims(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getGithubId());
        return claims;
    }

}
