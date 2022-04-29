package team14.sidedish.menu;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import team14.sidedish.common.Exception.InvalidOrderException;
import team14.sidedish.image.Image;

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
	private final Category category;
	@Column("INVENTORY_QUANTITY")
	private int inventoryQuantity;

	@MappedCollection(idColumn = "IMAGE_MENU_ID", keyColumn = "IMAGE_MENU_ID")
	private List<Image> images = new ArrayList<>();

	/**
	 *  type - DB
	 *  id - for view category_id
	 */
	@Getter
	@RequiredArgsConstructor
	public enum Category {
		SIDE_DISH("side_dish", "밑반찬", 1),
		MAIN_DISH("main_dish", "메인", 2),
		SOUP("soup", "국물",3);

		private final String type;
		private final String koType;
		private final int id;

		public static Category from(String category) {
			return Arrays.stream(Category.values())
				.filter(it -> it.getType().equals(category))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("no category name"));
		}

		public static Category from(int id) {
			return Arrays.stream(Category.values())
				.filter(it -> it.getId() == id)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("no category id"));
		}
	}

	protected static Menu of(String name, String description, BigDecimal price, String category, int inventoryQuantity) {
		return new Menu(null, name, description, price, category, inventoryQuantity);
	}

	protected Menu(Long menuId, String name, String description, BigDecimal price, String category, int inventoryQuantity) {
		this.menuId = menuId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = Category.from(category);
		this.inventoryQuantity = inventoryQuantity;
	}

	public int sold(int countOfOrder) {
		if (!compareQuantity(countOfOrder)) {
			throw new InvalidOrderException("품절되어 주문이 불가합니다.");
		}
		this.inventoryQuantity -= countOfOrder;
		return this.inventoryQuantity;
	}

	protected List<String> getImages() {
		return images.stream()
			.map(image -> image.getUrl())
			.collect(Collectors.toList());
	}

	protected boolean availableForSale() {
		return this.inventoryQuantity > 0;
	}

	private boolean compareQuantity(int countOfOrder) {
		return (this.inventoryQuantity - countOfOrder) >= 0;
	}

	public boolean availableForOrder(int countOfOrder) {
		return this.availableForSale() || this.compareQuantity(countOfOrder);
	}

	protected Long getMenuId() {
		return menuId;
	}

	protected BigDecimal getPrice() {
		return this.price;
	}

	protected String getName() {
		return name;
	}

	protected String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}
}

