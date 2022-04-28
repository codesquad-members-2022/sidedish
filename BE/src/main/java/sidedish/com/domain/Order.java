package sidedish.com.domain;

import lombok.Getter;

@Getter
public class Order {
	private final Product product;
	private final long count;
	private final long totalPrice;
	private final long deliveryPrice;

	public Order(Product product, long count) {
		this.product = product;
		this.count = count;
		this.totalPrice = calculateTotalPrice();
		this.deliveryPrice = calculateDeliveryPrice();
	}

	private long calculateTotalPrice() {
		return count * product.getFixedPrice();
	}

	private long calculateDeliveryPrice() {
		if (totalPrice >= product.getDeliveryPolicy().getFreeDeliveryOverAmount()) {
			return 0;
		}
		return product.getDeliveryPolicy().getDeliveryCharge();
	}
}
