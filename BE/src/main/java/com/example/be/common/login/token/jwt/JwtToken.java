package com.example.be.common.login.token.jwt;

public class JwtToken {
    private static final String TOKEN = "JwtToken";

    private final Header header;
    private final PayLoad payLoad;
    private final Signature signature;

    public JwtToken(String email) {
        this.header = createHeader();
        this.payLoad = createPayLoad(email);
        this.signature = createSignature(header, payLoad);
    }

    private Header createHeader() {
        return new Header();
    }

    private PayLoad createPayLoad(String email) {
        return new PayLoad(email);
    }

    private Signature createSignature(Header header, PayLoad payLoad) {
        return new Signature(header, payLoad);
    }

    public String getClaim(String attribute) {
        return payLoad.getClaim(attribute);
    }
}
