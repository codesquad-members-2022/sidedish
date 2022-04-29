package kr.codesquad.sidedish.web.dto.order;

import kr.codesquad.sidedish.domain.Order;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class OrderRequest {
    private Long itemId;
    private Long userId;
    @NotNull
    @Min(1)
    private Integer quantity;
    private Long totalPrice;

    public OrderRequest() {

    }

    public OrderRequest(Long itemId, Long userId, Integer quantity, Long totalPrice) {
        this.itemId = itemId;
        this.userId = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Order toEntity() {
        return Order.newOrder(this.itemId, this.userId, this.quantity, this.totalPrice);
    }

}
