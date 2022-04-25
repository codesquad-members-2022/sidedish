package com.example.be.common.token;

public class Registration {
    private final String scope;
    private final String tokenUrl;
    private final String userInfoUrl;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;

    public Registration(String scope, String tokenUrl, String userInfoUrl, String clientId, String clientSecret, String redirectUrl) {
        this.scope = scope;
        this.tokenUrl = tokenUrl;
        this.userInfoUrl = userInfoUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }

    private static class RegistrationBuilder {
        private String scope;
        private String tokenUrl;
        private String userInfoUrl;
        private String clientId;
        private String clientSecret;
        private String redirectUrl;

        private RegistrationBuilder scope(String scope) {
            this.scope = scope;
            return this;
        }

        private RegistrationBuilder tokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
            return this;
        }

        private RegistrationBuilder userInfoUrl(String userInfoUrl) {
            this.userInfoUrl = userInfoUrl;
            return this;
        }

        private RegistrationBuilder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        private RegistrationBuilder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        private RegistrationBuilder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }

        private Registration build() {
            return new Registration(scope, tokenUrl, userInfoUrl, clientId, clientSecret, redirectUrl);
        }
    }
}
