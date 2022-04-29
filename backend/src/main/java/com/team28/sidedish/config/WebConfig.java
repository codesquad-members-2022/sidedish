package com.team28.sidedish.config;

import com.team28.sidedish.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public TokenVerifyInterceptor tokenVerifyInterceptor() {
        return new TokenVerifyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenVerifyInterceptor())
//                .order(1)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**")
//                .excludePathPatterns("/login/**")
//                .excludePathPatterns("/swagger-ui/**")
//                .excludePathPatterns("/v3/api-docs/**");
    }
}
