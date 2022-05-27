package com.sidedish.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventBadge {
	none(0), launching(20), event(10);

	private final int discountRate;
}
