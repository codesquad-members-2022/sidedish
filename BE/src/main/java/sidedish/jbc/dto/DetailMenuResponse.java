package sidedish.jbc.dto;

import java.util.List;
import java.util.stream.Collectors;
import sidedish.jbc.domain.Image;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.SaleType;

public class DetailMenuResponse {

	private String name;
	private String description;
	private int price;
	private SaleType saleType;
	private String deliveryInfo;
	private int fee;
	private int freeShippingStartingPrice;
	private int stock;
	private List<String> mainImage;
	private List<String> detailImage;

	public DetailMenuResponse(Menu menu) {
		this.name = menu.getName();
		this.description = menu.getDescription();
		this.price = menu.getPrice();
		this.saleType = menu.getSaleType();
		this.deliveryInfo = menu.getDeliveryInfo();
		this.fee = menu.getFee();
		this.freeShippingStartingPrice = menu.getFreeShippingStartingPrice();
		this.stock = menu.getStock();
		mainImage = menu.getImages().stream()
			.filter(Image::getIsMainImage)
			.map(Image::getImagePath)
			.collect(Collectors.toList());
		detailImage = menu.getImages().stream()
			.filter(image -> !image.getIsMainImage())
			.map(Image::getImagePath)
			.collect(Collectors.toList());
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

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public int getFee() {
		return fee;
	}

	public int getFreeShippingStartingPrice() {
		return freeShippingStartingPrice;
	}

	public int getStock() {
		return stock;
	}

	public List<String> getMainImage() {
		return mainImage;
	}

	public List<String> getDetailImage() {
		return detailImage;
	}
}
