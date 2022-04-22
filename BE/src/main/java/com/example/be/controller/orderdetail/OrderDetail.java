package com.example.be.controller.orderdetail;

import java.math.BigDecimal;
import org.springframework.data.relational.core.mapping.Table;

@Table("orderdetail")
public class OrderDetail {

	private Long orderDetailId;
	private Long orderId;
	private Long dishId;
	private int dishCount;
	private BigDecimal orderPrice;

	public OrderDetail(Long orderDetailId, Long orderId, Long dishId, int dishCount,
		BigDecimal orderPrice) {
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.dishId = dishId;
		this.dishCount = dishCount;
		this.orderPrice = orderPrice;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Long getDishId() {
		return dishId;
	}

	public int getDishCount() {
		return dishCount;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}
}
