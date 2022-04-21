package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    private final Long order_id;
    private final Long banchan_id;
    private final Long member_id;
    private final Integer quantity;
    private final Integer total_price;

    public Order(Long order_id, Long banchan_id, Long member_id, Integer quantity, Integer total_price) {
        this.order_id = order_id;
        this.banchan_id = banchan_id;
        this.member_id = member_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getBanchan_id() {
        return banchan_id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotal_price() {
        return total_price;
    }
}
