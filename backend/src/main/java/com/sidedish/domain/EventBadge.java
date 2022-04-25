package com.sidedish.domain;

public enum EventBadge {
	NONE(1), LAUNCHING(0.8), EVENT(0.9);

	private final double discountAmount;

	EventBadge(final double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}
}
