package com.sidedish.domain.product;

public enum EventBadge {
	none(1), launching(0.8), event(0.9);

	private final double discountAmount;

	EventBadge(final double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}
}
