package sidedish.jbc.domain;

import java.util.HashMap;
import java.util.Map;

public enum MenuType {
	MAIN(1),
	SOUP(2),
	SIDE(3);

	private static final Map<String, MenuType> typeMap = new HashMap<>(Map.of(
		"main", MenuType.MAIN,
		"soup", MenuType.SOUP,
		"side", MenuType.SIDE
	));

	private final int typeValue;

	MenuType(int typeValue) {
		this.typeValue = typeValue;
	}

	public static MenuType getInstance(String type) {
		return typeMap.get(type);
	}

	public int getTypeValue() {
		return typeValue;
	}

}
