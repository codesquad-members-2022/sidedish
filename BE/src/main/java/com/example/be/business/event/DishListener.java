package com.example.be.business.event;

import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.event.dish.DishUpdatePublishEvent;
import com.example.be.common.annotation.EventListenerz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DishListener {

    private static final Logger logger = LoggerFactory.getLogger(DishListener.class);

    public DishListener() {
    }

    @EventListenerz
    public void onApplicationEvent(DishUpdatePublishEvent event) {
        Dish dish = event.getDish();
        logger.info("도메인 이벤트 발생: {}", dish);
    }
}
