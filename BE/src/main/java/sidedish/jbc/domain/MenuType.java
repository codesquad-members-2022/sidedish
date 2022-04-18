package sidedish.jbc.domain;

public enum MenuType {
	MAIN(1),
	SOUP(2),
	SIDE(3);

	private final int typeValue;

	MenuType(int typeValue) {
		this.typeValue = typeValue;
	}

	public int getTypeValue() {
		return typeValue;
	}

}
