package sidedish.jbc.domain;

public class Menu {

	private Long id;
	private String name;
	private String description;
	private int price;
	private int menuType;
	private int saleType;
	private int fee;
	private int freeShippingMin;
	private String deliveryInfo;
	private int inventory;
	private String imageURL;

	public Menu(Long id, String name, String description, int price, int menuType, int saleType,
		int fee, int freeShippingMin, String deliveryInfo, int inventory, String imageURL) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.fee = fee;
		this.freeShippingMin = freeShippingMin;
		this.deliveryInfo = deliveryInfo;
		this.inventory = inventory;
		this.imageURL = imageURL;
	}

	public Menu(String name, String description, int price, int menuType, int saleType, int fee,
		int freeShippingMin, String deliveryInfo, int inventory, String imageURL) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.fee = fee;
		this.freeShippingMin = freeShippingMin;
		this.deliveryInfo = deliveryInfo;
		this.inventory = inventory;
		this.imageURL = imageURL;
	}

}
