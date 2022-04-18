package sidedish.jbc.domain;

import java.math.BigDecimal;

public class Menu {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private int menuType;
	private int saleType;

	public Menu(Long id, String name, String description, BigDecimal price, int menuType,
		int saleType) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
	}

	public Menu(String name, String description, BigDecimal price, int menuType, int saleType) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
	}

}
