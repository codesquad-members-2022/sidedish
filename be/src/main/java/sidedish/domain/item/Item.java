package sidedish.domain.item;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import sidedish.domain.images.Image;

import java.util.List;

@Getter
public class Item {

	@Id
	private Long id;
	private Long mainCategoryId;
	private String title;
	private String description;
	private int price;
	private int quantity;
	@Transient
	private double accumulate;
	private String discountPolicy;
	@Transient
	private double discountRate;
	private boolean morningDelivery;
	@MappedCollection(idColumn = "item_id", keyColumn = "id")
	private List<Image> images;

	public Item(Long id, Long mainCategoryId, String title, String description, int price, int quantity, String discountPolicy, boolean morningDelivery, List<Image> images) {
		this.id = id;
		this.mainCategoryId = mainCategoryId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.accumulate = price * 0.01;
		this.discountPolicy = discountPolicy;
		this.discountRate = 0.1;
		this.morningDelivery = morningDelivery;
		this.images = images;
	}

	public boolean hasNotEnoughQuantity(int quantity) {
		return this.quantity < quantity;
	}

	public void reduceQuantity(int quantity) {
		this.quantity -= quantity;
	}
}
