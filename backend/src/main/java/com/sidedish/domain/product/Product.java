package com.sidedish.domain.product;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Product {
	@Id
	private Long id;
	private String productName;
	private String description;
	private int earlyDelivery;
	private int price;
	private int stock;
	private EventBadge eventBadge;
	private MainCategory mainCategory;
	private EventCategory eventCategory;

	@Builder
	public Product(Long id, String productName, String description, int earlyDelivery, int price, int stock, EventBadge eventBadge, MainCategory mainCategory, EventCategory eventCategory) {
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.earlyDelivery = earlyDelivery;
		this.price = price;
		this.stock = stock;
		this.eventBadge = eventBadge;
		this.mainCategory = mainCategory;
		this.eventCategory = eventCategory;
	}
}
