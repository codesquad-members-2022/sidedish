package com.example.be.business.event;

import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.event.dish.DishUpdatePublishEvent;
import com.example.be.common.annotation.EventListenerz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DishListener {

    @Autowired
    private final DishRepository dishRepository;

    public DishListener(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @EventListenerz
    public void onApplicationEvent(DishUpdatePublishEvent event) {
        Dish dish = event.getDish();
        dishRepository.save(dish);
    }
}
