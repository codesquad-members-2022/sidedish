package sidedish.jbc.dto;

public class ResponseMenu {

	private long id;
	private String name;
	private String description;
	private int price;
	private int menuType;
	private int saleType;
	private String imageURL;

	public ResponseMenu(long id, String name, String description, int price, int menuType,
		int saleType, String imageURL) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.imageURL = imageURL;
	}

}
