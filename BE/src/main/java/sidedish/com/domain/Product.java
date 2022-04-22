package sidedish.com.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class Product {
	private Long id;
	private DiscountPolicy discountPolicy;
	private List<Image> images;
	private String productName;
	private String description;
	private long fixedPrice;
	private long originalPrice;
	private String mealCategory;
	private String bestCategory;

	public Product(Long id, DiscountPolicy discountPolicy,
		List<Image> images, String productName, String description, long originalPrice,
		String mealCategory, String bestCategory) {
		this.id = id;
		this.discountPolicy = discountPolicy;
		this.images = images;
		this.productName = productName;
		this.description = description;
		this.originalPrice = originalPrice;
		this.mealCategory = mealCategory;
		this.bestCategory = bestCategory;
		this.fixedPrice = calculateFixedPrice();
	}

	private long calculateFixedPrice() {
		return discountPolicy.calculateFixedPrice(originalPrice);
	}
}
