package com.sidedish.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventCategory {
	meat("풍성한 고기 반찬"), simple("편리한 반찬 세트"), season("맛있는 제철 요리"), kids("우리 아이 영양 반찬");

	private final String name;
}
