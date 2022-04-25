package sidedish.jbc.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Menu {

	@Id
	private Long id;
	private String name;
	private String description;
	private Integer price;
	private MenuType menuType;
	private SaleType saleType;
	private Integer fee;
	private Integer freeShippingStartingPrice;
	private String deliveryInfo;
	private Integer stock;
	private String imagePath;

	@MappedCollection(idColumn = "MENU_ID", keyColumn = "ID")
	private List<Image> images;

	@PersistenceConstructor
	public Menu(Long id, String name, String description, Integer price,
		MenuType menuType, SaleType saleType, Integer fee, Integer freeShippingStartingPrice,
		String deliveryInfo, Integer stock, String imagePath, List<Image> images) {
		System.out.println("메뉴 생성자 호출");
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

	public Menu(Long id, String name, String description, Integer price,
		MenuType menuType, SaleType saleType, Integer fee, Integer freeShippingStartingPrice,
		String deliveryInfo, Integer stock, String imagePath) {
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
	}

	@Override
	public String toString() {
		return "Menu{" +
			"id=" + id +
			", name='" + name + '\'' +
			", description='" + description + '\'' +
			", price=" + price +
			", menuType=" + menuType +
			", saleType=" + saleType +
			", fee=" + fee +
			", freeShippingStartingPrice=" + freeShippingStartingPrice +
			", deliveryInfo='" + deliveryInfo + '\'' +
			", stock=" + stock +
			", imagePath='" + imagePath + '\'' +
			", imageTest=" + images +
			'}';
	}
}
