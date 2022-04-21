package sidedish.jbc.dto;

import java.util.List;
import java.util.stream.Collectors;

public class DetailMenuResponse {

	private String name;
	private String description;
	private int price;
	private String saleType;
	private String deliveryInfo;
	private int fee;
	private int freeShippingMin;
	private List<String> mainImage;
	private List<String> detailImage;

	public DetailMenuResponse(DetailMenuInfo menuInfo, List<DetailMenuImages> menuImages) {
		this.name = menuInfo.getName();
		this.description = menuInfo.getDescription();
		this.price = menuInfo.getPrice();
		this.saleType = menuInfo.getSaleType();
		this.deliveryInfo = menuInfo.getDeliveryInfo();
		this.fee = menuInfo.getFee();
		this.freeShippingMin = menuInfo.getFreeShippingMin();
		this.mainImage = menuImages.stream()
			.filter(DetailMenuImages::isMain)
			.map(DetailMenuImages::getImagePath)
			.collect(Collectors.toList());
		this.detailImage =  menuImages.stream()
			.filter(c -> !c.isMain())
			.map(DetailMenuImages::getImagePath)
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

	public String getSaleType() {
		return saleType;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public int getFee() {
		return fee;
	}

	public int getFreeShippingMin() {
		return freeShippingMin;
	}

	public List<String> getMainImage() {
		return mainImage;
	}

	public List<String> getDetailImage() {
		return detailImage;
	}
}
