package sidedish.jbc.dto;

import java.math.BigDecimal;

public class ResponseMenu {

	private long id;
	private String name;
	private String description;
	private BigDecimal price;
	private int menuType;
	private int saleType;
	private String imageURL;

	public ResponseMenu(long id, String name, String description, BigDecimal price, int menuType,
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
