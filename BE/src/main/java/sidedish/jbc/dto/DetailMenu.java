package sidedish.jbc.dto;

public class DetailMenu {

	private String name;
	private String description;
	private int price;
	private String saleType;
	private String deliveryInfo;
	private int fee;
	private int freeShippingStartingPrice;

	public DetailMenu(String name, String description, int price, String saleType,
		String deliveryInfo, int fee, int freeShippingStartingPrice) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.saleType = saleType;
		this.deliveryInfo = deliveryInfo;
		this.fee = fee;
		this.freeShippingStartingPrice = freeShippingStartingPrice;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getSaleType() {
		return saleType;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public int getFee() {
		return fee;
	}

	public int getFreeShippingStartingPrice() {
		return freeShippingStartingPrice;
	}
}
