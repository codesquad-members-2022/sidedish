package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class DiscountEventResponse {

    @ApiModelProperty(required = true, value = "할인 이벤트 아이디")
    private long discountEventId;

    @ApiModelProperty(required = true, value = "할인 이벤트 타이틀")
    private String title;

    public static DiscountEventResponse from(DiscountEvent discountEvent) {
        return new DiscountEventResponse(discountEvent.getId(), discountEvent.getTitle());
    }
}
