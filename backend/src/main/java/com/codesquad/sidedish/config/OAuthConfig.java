package com.codesquad.sidedish.config;

import com.codesquad.sidedish.auth.LoginFilter;
import com.codesquad.sidedish.auth.domain.OAuthProperties;
import com.codesquad.sidedish.order.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:oauth.properties")
@EnableConfigurationProperties(OAuthProperties.class)
public class OAuthConfig {

    private final OAuthProperties properties;
    private final UserRepository userRepository;

    @Bean
    public FilterRegistrationBean<LoginFilter> logFilter() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter(userRepository));
        registrationBean.addUrlPatterns("/api/order");
        return registrationBean;
    }
}
