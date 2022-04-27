package com.terria.sidedish.dto.request;

import com.terria.sidedish.domain.entity.aggregate.OrderSheet;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSheetRequest {

    private int quantity;
    private int totalAmount;

    private long sideDishId;
    private long memberId;

    public OrderSheet toEntity() {
        return OrderSheet.of(quantity, totalAmount, sideDishId, memberId);
    }
}
