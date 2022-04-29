package sidedish.com.domain;

import java.util.List;
import lombok.Getter;
import sidedish.com.exception.NotEnoughStockQuantityException;

@Getter
public class Product {

	public static final long MILEAGE_RATE = 100L;

	private final Long id;
	private final DiscountPolicy discountPolicy;
	private final DeliveryPolicy deliveryPolicy;
	private final List<Image> images;
	private final String productName;
	private final String description;
	private final long fixedPrice;
	private final long originalPrice;
	private long stockQuantity;
	private final String mealCategory;
	private final String bestCategory;
	private final long mileage;

	public Product(Long id, DiscountPolicy discountPolicy,
		DeliveryPolicy deliveryPolicy, List<Image> images, String productName,
		String description, long originalPrice, long stockQuantity, String mealCategory,
		String bestCategory) {
		if (stockQuantity < 0) {
			throw new NotEnoughStockQuantityException(stockQuantity);
		}
		this.id = id;
		this.discountPolicy = discountPolicy;
		this.deliveryPolicy = deliveryPolicy;
		this.images = images;
		this.productName = productName;
		this.description = description;
		this.originalPrice = originalPrice;
		this.stockQuantity = stockQuantity;
		this.mealCategory = mealCategory;
		this.bestCategory = bestCategory;
		this.fixedPrice = calculateFixedPrice();
		this.mileage = calculateMileage();
	}

	private long calculateMileage() {
		return fixedPrice / MILEAGE_RATE;
	}

	private long calculateFixedPrice() {
		return discountPolicy.calculateFixedPrice(originalPrice);
	}

	public void minusStockQuantity(long count) {
		if (count > stockQuantity) {
			throw new NotEnoughStockQuantityException(stockQuantity);
		}
		stockQuantity -= count;
	}
}
