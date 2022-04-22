package com.example.be.domain.order;

import java.math.BigDecimal;
import org.springframework.data.relational.core.mapping.Table;

@Table("order")
public class Order {
	private Long orderId;
	private Long userId;
	private Long dishId;
	private BigDecimal orderPrice;

	public Order(Long orderId, Long userId, Long dishId, BigDecimal orderPrice) {
		this.orderId = orderId;
		this.userId = userId;
		this.dishId = dishId;
		this.orderPrice = orderPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getDishId() {
		return dishId;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
}
