package com.example.be.common.token;

public class ClientRegistration {
    private final String scope;
    private final String tokenUrl;
    private final String userInfoUrl;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;

    public ClientRegistration(String scope, String tokenUrl, String userInfoUrl, String clientId, String clientSecret, String redirectUrl) {
        this.scope = scope;
        this.tokenUrl = tokenUrl;
        this.userInfoUrl = userInfoUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }

    private static class Builder {
        private String scope;
        private String tokenUrl;
        private String userInfoUrl;
        private String clientId;
        private String clientSecret;
        private String redirectUrl;

        private Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        private Builder tokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
            return this;
        }

        private Builder userInfoUrl(String userInfoUrl) {
            this.userInfoUrl = userInfoUrl;
            return this;
        }

        private Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        private Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        private Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        private ClientRegistration build() {
            return new ClientRegistration(scope, tokenUrl, userInfoUrl, clientId, clientSecret, redirectUrl);
        }
    }
}
