package com.sidedish.domain.product;

import lombok.Builder;

public class ProductOrder {
	private Long id;
	private Long productId;
	private Long userId;
	private int quantity;

	public ProductOrder(Long id, Long productId, Long userId, int quantity) {
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
	}
}
