package com.team35.sidedish.domain.entity.link;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SideDishHasDiscountEvent {

    private long discountEventId;

    @Override
    public String toString() {
        return "SideDishHasDiscountEvent{" +
                "discountEventId=" + discountEventId +
                '}';
    }
}
