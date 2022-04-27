package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.Member;
import com.terria.sidedish.domain.entity.aggregate.OrderSheet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class OrderSheetResponse {

    @ApiModelProperty(required = true, value = "주문서 아이디")
    private long id;

    @ApiModelProperty(required = true, value = "주문 개수")
    private int quantity;

    @ApiModelProperty(required = true, value = "총 가격")
    private int totalAmount;

    @ApiModelProperty(required = true, value = "주문 날짜")
    private LocalDateTime createdAt;

    public static OrderSheetResponse from(OrderSheet orderSheet) {
        return new OrderSheetResponse(orderSheet.getId(), orderSheet.getQuantity(), orderSheet.getTotalAmount(), orderSheet.getCreatedAt());
    }
}
