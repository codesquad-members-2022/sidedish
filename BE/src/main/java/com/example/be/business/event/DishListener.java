package com.example.be.business.event;

import com.example.be.business.event.dish.DishUpdatePublishEvent;
import com.example.be.common.annotation.EventListenerz;

public class DishListener  {

    @EventListenerz
    public void onApplicationEvent(DishUpdatePublishEvent event) {

    }
}
