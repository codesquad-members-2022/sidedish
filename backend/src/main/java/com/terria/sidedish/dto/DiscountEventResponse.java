package com.terria.sidedish.dto;

import com.terria.sidedish.domain.DiscountEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiscountEventResponse {

    private long id;
    private String title;

    public static DiscountEventResponse of(DiscountEvent discountEvent) {
        return new DiscountEventResponse(discountEvent.getId(), discountEvent.getTitle());
    }
}
