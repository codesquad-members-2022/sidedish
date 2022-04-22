package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiscountEventResponse {

    private long discountEventId;
    private String title;

    public static DiscountEventResponse from(DiscountEvent discountEvent) {
        return new DiscountEventResponse(discountEvent.getId(), discountEvent.getTitle());
    }
}
