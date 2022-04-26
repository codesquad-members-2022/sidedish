package kr.codesquad.sidedish.web.dto.order;

import kr.codesquad.sidedish.domain.Order;

public class OrderResponse {

    private Long orderId;

    public OrderResponse(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public static OrderResponse from(Order saved) {
        return new OrderResponse(saved.getOrderId());
    }
}
