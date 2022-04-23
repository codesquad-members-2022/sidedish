package sidedish.jbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Menu {

	@Id
	private Long id;
	private String name;
	private String description;
	private int price;
	private MenuType menuType;
	private SaleType saleType;
	private int fee;
	private int freeShippingMin;
	private String deliveryInfo;
	private int stock;
	private String imagePath;

	@PersistenceConstructor
	public Menu(Long id, String name, String description, int price,
		MenuType menuType, SaleType saleType, int fee, int freeShippingMin,
		String deliveryInfo, int stock, String imagePath) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.fee = fee;
		this.freeShippingMin = freeShippingMin;
		this.deliveryInfo = deliveryInfo;
		this.stock = stock;
		this.imagePath = imagePath;
	}

	public Menu(String name, String description, int price, MenuType menuType,
		SaleType saleType, int fee, int freeShippingMin, String deliveryInfo, int stock,
		String imagePath) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.fee = fee;
		this.freeShippingMin = freeShippingMin;
		this.deliveryInfo = deliveryInfo;
		this.stock = stock;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu{" +
			"id=" + id +
			", name='" + name + '\'' +
			", description='" + description + '\'' +
			", price=" + price +
			", menuType=" + menuType +
			", saleType=" + saleType +
			", fee=" + fee +
			", freeShippingMin=" + freeShippingMin +
			", deliveryInfo='" + deliveryInfo + '\'' +
			", stock=" + stock +
			", imagePath=" + imagePath +
			'}';
	}
}
