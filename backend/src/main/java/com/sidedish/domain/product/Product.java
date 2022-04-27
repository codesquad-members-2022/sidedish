package com.sidedish.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
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

	@MappedCollection(idColumn = "id", keyColumn = "id")
	private final Map<Long, String> images = new HashMap();

	public void addImage(Long imageId, String imagePath){
		images.put(imageId,imagePath);
	}
}
