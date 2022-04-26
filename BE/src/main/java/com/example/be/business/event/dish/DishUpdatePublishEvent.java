package com.example.be.business.event.dish;

import com.example.be.business.dish.domain.Dish;
import com.example.be.business.event.common.ApplicationEventz;

public class DishUpdatePublishEvent extends ApplicationEventz {

    /**
     * 애그리게잇이 save되는 순간 같은 애그리게잇 내 모든 엔티티들이
     * 업데이트 되기 때문에 해당 부분에 repository 존재. 컨셉을
     * 유지하기 위해 넣었습니다.
     */

    private final Dish dish;

    public DishUpdatePublishEvent(Object source) {
        super(source);
        this.dish = (Dish) source;
    }
}
