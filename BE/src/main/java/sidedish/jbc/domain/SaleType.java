package sidedish.jbc.domain;

public enum SaleType {

	NONE(1),
	LAUNCH(2),
	EVENT(3);

	private final int typeValue;

	SaleType(int typeValue) {
		this.typeValue = typeValue;
	}

	public int getTypeValue() {
		return typeValue;
	}

}
