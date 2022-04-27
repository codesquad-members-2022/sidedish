package com.sidedish.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventBadge {
	none(1), launching(0.8), event(0.9);

	private final double discountRate;
}
