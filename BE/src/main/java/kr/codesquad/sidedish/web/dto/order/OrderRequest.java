package kr.codesquad.sidedish.web.dto.order;

import kr.codesquad.sidedish.domain.Order;

public class OrderRequest {
    private Long itemId;
    private String email;
    private Integer quantity;
    private Long totalPrice;

    public OrderRequest() {

    }

    public OrderRequest(Long itemId, String email, Integer quantity, Long totalPrice) {
        this.itemId = itemId;
        this.email = email;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Order toEntity() {
        return Order.newOrder(this.itemId, this.email, this.quantity, this.totalPrice);
    }

    public Long getItemId() {
        return itemId;
    }

    public String getEmail() {
        return email;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
}
