package sidedish.jbc.dto;

public class MenuResponse {

	private long id;
	private String name;
	private String description;
	private int price;
	private String menuType;
	private String saleType;
	private String imagePath;

	public MenuResponse(long id, String name, String description, int price, String menuType,
		String saleType, String imagePath) {
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

	public String getMenuType() {
		return menuType;
	}

	public String getSaleType() {
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
