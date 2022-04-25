package com.example.be.common.token.jwt;

import org.apache.tomcat.util.codec.binary.Base64;

public class Header {
    private static final String type = "JWT";
    private static final String alg = "H256";
    private static final String TOKEN_DELIMETER = ",";

    @Override
    public String toString() {
        String header = "type:" + type + TOKEN_DELIMETER + "alg:" + alg;
        byte[] encodedHeader = Base64.encodeBase64(header.getBytes());
        return new String(encodedHeader);
    }
}
