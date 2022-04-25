package com.example.be.common.token;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.HashMap;
import java.util.Map;

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.oauth.client")
public class OauthClientProperties {

    private final Map<String, Registration> registration = new HashMap<>();

    private final Map<String, Provider> provider = new HashMap<>();

    public OauthClientProperties() {}

    public Map<String, Registration> getRegistration() {
        return registration;
    }

    public Map<String, Provider> getProvider() {
        return provider;
    }

    public static class Registration {
        private final String clientId;
        private final String clientSecret;
        private final String redirectUri;

        public Registration(String clientId, String clientSecret, String redirectUri) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            this.redirectUri = redirectUri;
        }

        public String getClientId() {
            return clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public String getRedirectUri() {
            return redirectUri;
        }
    }

    static class Provider {
        private final String tokenUri;
        private final String userInfoUri;
        private String userNameAttribute;
        private final String userAuthrozationUri;

        public Provider(String tokenUri, String userInfoUri, String userNameAttribute, String userAuthrozationUri) {
            this.tokenUri = tokenUri;
            this.userInfoUri = userInfoUri;
            this.userNameAttribute = userNameAttribute;
            this.userAuthrozationUri = userAuthrozationUri;
        }

        public String getTokenUri() {
            return tokenUri;
        }

        public String getUserInfoUri() {
            return userInfoUri;
        }

        public String getUserNameAttribute() {
            return userNameAttribute;
        }

        public String getUserAuthrozationUri() {
            return userAuthrozationUri;
        }
    }
}
