package com.codesquad.sidedish.event_badge.dto;

import com.codesquad.sidedish.event_badge.domain.EventBadge;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class EventBadgeResponse {

    private final Integer eventBadgeId;
    private final String eventBadgeName;
    private final Float discount;

    public static EventBadgeResponse from(EventBadge eventBadge) {
        return new EventBadgeResponse(
            eventBadge.getId(),
            eventBadge.getEventBadgeName(),
            eventBadge.getDiscount()
        );
    }
}
