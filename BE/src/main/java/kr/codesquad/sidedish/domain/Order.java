package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {

    @Id
    private Long orderId;
    private Long itemId;
    private Long userId;
    private Integer quantity;
    private Long totalPrice;

    public Order(Long orderId, Long itemId, Long userId, Integer quantity, Long totalPrice) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.userId = userId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static Order newOrder(Long itemId, Long userId, Integer quantity, Long totalPrice) {
        return new Order(null, itemId, userId, quantity, totalPrice);
    }

    public Long getOrderId() {
        return orderId;
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
