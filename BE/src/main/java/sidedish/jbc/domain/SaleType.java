package sidedish.jbc.domain;

public enum SaleType {

	NONE(0),
	LAUNCH(20),
	EVENT(10);

	private final int salePercentage;

	SaleType(int salePercentage) {
		this.salePercentage = salePercentage;
	}

	public int getSalePercentage() {
		return salePercentage;
	}

	public int calculateSalePrice(int price) {
		return (int) (price * (100 - this.getSalePercentage()) / 100f);
	}

}
