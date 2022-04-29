package com.codesquad.sidedish.auth.domain;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ToString
@ConfigurationProperties(prefix = "oauth")
public class OAuthProperties {

    private final Map<String, OAuthProvider> provider = new HashMap<>();

    public OAuthProvider getProvider(String name) {
        return provider.get(name);
    }

}
