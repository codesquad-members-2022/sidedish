package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private final Long orderId;
    private final Long itemId;
    private final Long userId;
    private final Integer quantity;
    private final Integer totalPrice;

    public Order(Long orderId, Long itemId, Long userId, Integer quantity, Integer totalPrice) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.userId = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
