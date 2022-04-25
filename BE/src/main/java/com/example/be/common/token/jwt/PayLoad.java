package com.example.be.common.token.jwt;

import org.apache.tomcat.util.codec.binary.Base64;

import java.time.LocalDateTime;
import java.util.UUID;

public class PayLoad {

    private static final String ISSUER = "CodeSquad";
    private static final String SUBJECT = "Sidedish";
    private static final String AUDIENCE = "Sidedish User";
    private static final String EXPIRATION_TIME = "exp";
    private static final String NOT_BEFORE = "nbf";
    private static final String ISSUED_AT = "2022-04-26";
    private static final String JWT_ID = "ja12fo=93mfasfjo1234";
    private static final String TOKEN_DELIMETER = ",";

    // TODO 추후 long으로 변경
    private LocalDateTime expirationTime;
    private LocalDateTime notBefore;
    private LocalDateTime issuedAt;
    private final String jwtId = UUID.randomUUID().toString();

    public PayLoad() {
        this.expirationTime = LocalDateTime.now().plusDays(7);
        this.notBefore = LocalDateTime.now().plusDays(7);
        this.issuedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String payLoad = getPayLoad();
        byte[] encodedHeader = Base64.encodeBase64(payLoad.getBytes());
        return new String(encodedHeader);
    }

    private static String getPayLoad() {
        return new StringBuffer().append("iss:").append(ISSUER).append(TOKEN_DELIMETER)
                .append("sub:").append(SUBJECT).append(TOKEN_DELIMETER)
                .append("aud:").append(AUDIENCE).append(TOKEN_DELIMETER)
                .append("exp:").append(EXPIRATION_TIME).append(TOKEN_DELIMETER)
                .append("nbf:").append(NOT_BEFORE).append(TOKEN_DELIMETER)
                .append("iat:").append(ISSUED_AT).append(TOKEN_DELIMETER)
                .append("jti:").append(JWT_ID).toString();
    }

}
