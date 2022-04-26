package com.sidedish.domain.product;

public enum EventCategory {
	meat("풍성한 고기 반찬"), simple("편리한 반찬 세트"), season("맛있는 제철 요리"), kids("우리 아이 영양 반찬");

	private final String name;

	EventCategory(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
