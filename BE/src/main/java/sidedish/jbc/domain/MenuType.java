package sidedish.jbc.domain;

import java.util.HashMap;
import java.util.Map;

public enum MenuType {
	MAIN,
	SOUP,
	SIDE;

	private static final Map<String, MenuType> typeMap = new HashMap<>(Map.of(
		"main", MenuType.MAIN,
		"soup", MenuType.SOUP,
		"side", MenuType.SIDE
	));

	public static MenuType getInstance(String type) {
		return typeMap.get(type);
	}

}
