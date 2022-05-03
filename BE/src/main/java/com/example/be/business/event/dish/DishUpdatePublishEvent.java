package com.example.be.business.event.dish;

import com.example.be.business.dish.domain.Dish;
import com.example.be.business.event.DishListener;
import com.example.be.business.event.common.ApplicationEventz;

public class DishUpdatePublishEvent extends ApplicationEventz {

    private DishListener dishListener;
    private  Dish dish;

    public DishUpdatePublishEvent(Object source) {
        super(source);
        this.dishListener = new DishListener();
        this.dish = (Dish) source;
        dishListener.onApplicationEvent(this);
    }

    public Dish getDish() {
        return dish;
    }
}
