package com.team28.sidedish.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final Algorithm algorithm = Algorithm.HMAC256(EnvUtils.getJwtSecret());
    private static final JWTVerifier verifier = JWT.require(algorithm).build();
    private static final long expiredTime = 100 * 60 * 60 * 48L; // 48 시간


    public static String createToken(Map<String, Object> payload) {
        Date expiredDate = new Date();
        expiredDate.setTime(expiredDate.getTime() + expiredTime);

        return JWT.create()
                .withPayload(payload)
                .withExpiresAt(expiredDate)
                .sign(algorithm);
    }

    public static boolean isValidToken(String token) {
        try {
            DecodedJWT jwt = verifier.verify(token);

            return isExpiredToken(jwt.getExpiresAt());
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isExpiredToken(Date expiresAt) {
        return new Date().getTime() < expiresAt.getTime();
    }
}
