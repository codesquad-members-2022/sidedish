package com.team35.sidedish.dto.request;

import com.team35.sidedish.domain.entity.aggregate.OrderSheet;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@ApiModel
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSheetRequest {

    @NotNull(message = "주문 상품의 개수가 존재하지 않습니다.")
    private int quantity;
    
    private int totalAmount;

    @NotNull(message = "상품 아이디가 존재하지 않습니다.")
    private long sideDishId;

    @NotNull(message = "로그인 정보가 존재하지 않습니다.")
    private long memberId;

    public OrderSheet toEntity() {
        return OrderSheet.of(quantity, totalAmount, sideDishId, memberId);
    }
}
