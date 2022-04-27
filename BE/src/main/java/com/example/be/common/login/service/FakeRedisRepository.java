package com.example.be.common.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FakeRedisRepository {

    private Logger logger = LoggerFactory.getLogger(FakeRedisRepository.class);

    private Map<String, String> redis = new ConcurrentHashMap<>();

    public void save(String jwtToken) {
        Assert.notNull(jwtToken, "Token must be not null.");
        logger.info("FakeRedis에 토큰 저장 - 토큰번호: {}", jwtToken);
        redis.put(jwtToken, jwtToken);
    }
}
