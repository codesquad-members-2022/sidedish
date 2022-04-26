package kr.codesquad.sidedish.web.dto.order;

import kr.codesquad.sidedish.domain.Order;

public class OrderRequest {
    private Long itemId;
    private Long userId;
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

    public Long getItemId() {
        return itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
}
