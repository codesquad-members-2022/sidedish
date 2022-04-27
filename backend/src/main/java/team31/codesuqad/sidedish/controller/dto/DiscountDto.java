package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.DiscountPolicies;

public class DiscountDto {

    private Integer eventId;
    private String eventName;
    private Integer discount;

    public DiscountDto(DiscountPolicies discountPolicies) {
        eventId = discountPolicies.getId();
        eventName = discountPolicies.getName();
        discount = discountPolicies.getDiscountRate();
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
