package com.sidedish.domain;

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

	public class Builder {
		private Long id;
		private Long productId;
		private Long userId;
		private int quantity;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder productId(Long productId) {
			this.productId = productId;
			return this;
		}

		public Builder userId(Long userId) {
			this.userId = userId;
			return this;
		}

		public Builder quantity(int quantity) {
			this.quantity = quantity;
			return this;
		}

		public ProductOrder build() {
			return new ProductOrder(id, productId, userId, quantity);
		}
	}
}
