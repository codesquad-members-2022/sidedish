package com.example.be.common.token.configuration;

public class ClientRegistration {
    private final String scope;
    private final String tokenUrl;
    private final String userInfoUrl;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUrl;

    public static ClientRegistration bind(OauthClientProperties.Registration registration, OauthClientProperties.Provider provider) {
        return new ClientRegistration(null, provider.getTokenUri(), provider.getUserInfoUri(), registration.getClientId(), registration.getClientSecret(), registration.getRedirectUri());
    }

    public ClientRegistration(String scope, String tokenUrl, String userInfoUrl, String clientId, String clientSecret, String redirectUrl) {
        this.scope = scope;
        this.tokenUrl = tokenUrl;
        this.userInfoUrl = userInfoUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUrl = redirectUrl;
    }

    public String getScope() {
        return scope;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Override
    public String toString() {
        return "ClientRegistration{" +
                "scope='" + scope + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                ", userInfoUrl='" + userInfoUrl + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
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
