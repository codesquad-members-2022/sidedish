package sidedish.jbc.dto;

import sidedish.jbc.domain.MenuType;
import sidedish.jbc.domain.SaleType;

public class MenuResponse {

	private long id;
	private String name;
	private String description;
	private int price;
	private int salePrice;
	private MenuType menuType;
	private SaleType saleType;
	private String imagePath;

	public MenuResponse(long id, String name, String description, int price, MenuType menuType,
		SaleType saleType, String imagePath) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.salePrice = price - price * saleType.getSalePercentage() / 100;
		this.menuType = menuType;
		this.saleType = saleType;
		this.imagePath = imagePath;
	}

	public long getId() {
		return id;
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

	public MenuType getMenuType() {
		return menuType;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public String getImagePath() {
		return imagePath;
	}

	public int getSalePrice() {
		return salePrice;
	}

	@Override
	public String toString() {
		return "ResponseMenu{" +
			"id=" + id +
			", name='" + name + '\'' +
			", description='" + description + '\'' +
			", price=" + price +
			", menuType=" + menuType +
			", saleType=" + saleType +
			", imageURL='" + imagePath + '\'' +
			'}';
	}
}
