package com.example.be.common.token.jwt;

import org.apache.tomcat.util.codec.binary.Base64;

public class Header {
    private static final String TYPE = "JWT";
    private static final String ALG = "H256";
    private static final String TOKEN_DELIMETER = ",";

    @Override
    public String toString() {
        String header = "type:" + TYPE + TOKEN_DELIMETER + "alg:" + ALG;
        byte[] encodedHeader = Base64.encodeBase64(header.getBytes());
        return new String(encodedHeader);
    }
}
