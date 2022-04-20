package sidedish.jbc.dto;

import org.springframework.data.annotation.Id;

public class ResponseMenu {

	@Id
	private long id;
	private String name;
	private String description;
	private int price;
	private int menuType;
	private int saleType;
	private String imagePath;

	public ResponseMenu(long id, String name, String description, int price, int menuType,
		int saleType, String imagePath) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public int getMenuType() {
		return menuType;
	}

	public int getSaleType() {
		return saleType;
	}

	public String getImagePath() {
		return imagePath;
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
