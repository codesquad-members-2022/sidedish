package team14.sidedish.menu;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

import lombok.ToString;

@ToString
@Table("SIDEDISH_MENUS")
public class Menu {
	@Id
	@Column("MENU_ID")
	private Long menuId;
	@Column("MENU_NAME")
	private final String name;
	@Column("DESCRIPTION")
	private final String description;
	@Column("MENU_PRICE")
	private final BigDecimal price;
	@Column("MENU_CATEGORY")
	private final String category;
	@Column("INVENTORY_QUANTITY")
	private final int inventoryQuantity;

	protected static Menu of(String name, String description, BigDecimal price, String category, int inventoryQuantity) {
		return new Menu(null, name, description, price, category, inventoryQuantity);
	}

	protected Menu(Long menuId, String name, String description, BigDecimal price, String category,
		int inventoryQuantity) {
		this.menuId = menuId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.inventoryQuantity = inventoryQuantity;
	}
}

