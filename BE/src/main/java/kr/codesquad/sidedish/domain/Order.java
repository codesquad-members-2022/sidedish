package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private final Long order_id;
    private final Long item_id;
    private final Long user_id;
    private final Integer quantity;
    private final Integer total_price;

    public Order(Long order_id, Long item_id, Long user_id, Integer quantity, Integer total_price) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotal_price() {
        return total_price;
    }
}
