package sidedish.jbc.domain;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Menu {

	@Id
	private Long id;
	private String name;
	private String description;
	private int price;
	private MenuType menuType;
	private SaleType saleType;
	private int fee;
	private int freeShippingStartingPrice;
	private String deliveryInfo;
	private int stock;
	private String imagePath;
	@MappedCollection(idColumn = "MENU_ID", keyColumn = "ID")
	private List<Image> images;

	@PersistenceConstructor
	public Menu(Long id, String name, String description, int price,
		MenuType menuType, SaleType saleType, int fee, int freeShippingStartingPrice,
		String deliveryInfo, Integer stock, String imagePath, List<Image> images) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.menuType = menuType;
		this.saleType = saleType;
		this.fee = fee;
		this.freeShippingStartingPrice = freeShippingStartingPrice;
		this.deliveryInfo = deliveryInfo;
		this.stock = stock;
		this.imagePath = imagePath;
		this.images = images;
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

	public SaleType getSaleType() {
		return saleType;
	}

	public int getFee() {
		return fee;
	}

	public int getFreeShippingStartingPrice() {
		return freeShippingStartingPrice;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public int getStock() {
		return stock;
	}

	public List<Image> getImages() {
		return images;
	}
}
