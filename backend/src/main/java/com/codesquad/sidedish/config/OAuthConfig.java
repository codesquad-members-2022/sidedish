package com.codesquad.sidedish.config;

import com.codesquad.sidedish.auth.domain.OAuthProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application-oauth.properties")
@EnableConfigurationProperties(OAuthProperties.class)
public class OAuthConfig {

    private final OAuthProperties properties;

}
