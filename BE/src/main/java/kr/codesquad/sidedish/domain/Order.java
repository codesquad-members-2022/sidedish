package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {

    @Id
    private Long orderId;
    private Long itemId;
    private String email;
    private Integer quantity;
    private Long totalPrice;

    public Order(Long orderId, Long itemId, String email, Integer quantity, Long totalPrice) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.email = email;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static Order newOrder(Long itemId, String email, Integer quantity, Long totalPrice) {
        return new Order(null, itemId, email, quantity, totalPrice);
    }

    public Long getOrderId() {
        return orderId;
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
