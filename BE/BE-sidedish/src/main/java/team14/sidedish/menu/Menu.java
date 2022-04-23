package team14.sidedish.menu;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table("SIDEDISH_MENUS")
public class Menu {
	@Id
	@Column("MENU_ID")
	private Long menuId;
	@Column("MENU_NAME")
	private String name;
	@Column("DESCRIPTION")
	private String description;
	@Column("MENU_PRICE")
	private BigDecimal price;
	@Column("MENU_CATEGORY")
	private String category;
	@Column("INVENTORY_QUANTITY")
	private int inventoryQuantity;

	protected static Menu of(String name, String description, BigDecimal price, String category, int inventoryQuantity) {
		return new Menu(null, name, description, price, category, inventoryQuantity);
	}
}

