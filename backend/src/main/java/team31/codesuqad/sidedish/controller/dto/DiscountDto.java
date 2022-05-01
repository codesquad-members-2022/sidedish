package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.DiscountPolicy;

public class DiscountDto {

    private final Integer eventId;
    private final String eventName;
    private final Integer discount;

    public DiscountDto(DiscountPolicy discountPolicy) {
        eventId = discountPolicy.getId();
        eventName = discountPolicy.getName();
        discount = discountPolicy.getDiscountRate();
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public Integer getDiscount() {
        return discount;
    }
}
