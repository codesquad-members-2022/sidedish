package com.example.be.common.token.jwt;

public class JwtToken {
    private static final String TOKEN = "JwtToken";

    private final Header header;
    private final PayLoad payLoad;
    private final Signature signature;

    public JwtToken(String email) {
        this.header = createHeader();
        this.payLoad = createPayLoad(email);
        this.signature = createSignature();
    }

    private Header createHeader() {
        return new Header();
    }

    private PayLoad createPayLoad(String email) {
        return new PayLoad();
    }

    private Signature createSignature() {
        return new Signature();
    }
}
