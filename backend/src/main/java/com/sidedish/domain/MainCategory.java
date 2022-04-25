package com.sidedish.domain;

public enum MainCategory {
	MAIN("모두가 좋아하는 든든한 메인 요리"), SOUP("정성이 담긴 뜨끈뜨끈 국물 요리"), SIDE("식탁을 풍성하게 하는 정갈한 밑반찬");

	private final String name;

	MainCategory(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
