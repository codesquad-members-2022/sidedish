package com.team35.sidedish.dto.response.sidedish;

import com.team35.sidedish.domain.entity.reference.DiscountEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountEventResponse {

    @ApiModelProperty(required = true, value = "할인 이벤트 아이디")
    private long discountEventId;

    @ApiModelProperty(required = true, value = "할인 이벤트 타이틀")
    private String title;

    public static DiscountEventResponse from(DiscountEvent discountEvent) {
        return new DiscountEventResponse(discountEvent.getId(), discountEvent.getTitle());
    }
}
