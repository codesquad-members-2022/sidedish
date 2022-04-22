package com.sidedish.domain;

public enum EventCategory {
	MEAT("풍성한 고기 반찬"), SIMPLE("편리한 반찬 세트"), SEASON("맛있는 제철 요리"), KIDS("우리 아이 영양 반찬");

	private final String name;

	EventCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
