package com.example.be.common.token.configuration;

import java.util.HashMap;
import java.util.Map;

public final class OauthClientPropertiesRegistrationAdapter {

    public static Map<String, ClientRegistration> getOauthProviders(OauthClientProperties properties) {
        Map<String, ClientRegistration> oauthProvider = new HashMap<>();

        properties.getRegistration().forEach((key, value) -> oauthProvider.put(key,
                ClientRegistration.bind(value, properties.getProvider().get(key))));
        return oauthProvider;
    }
}
