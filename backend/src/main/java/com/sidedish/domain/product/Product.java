package com.sidedish.domain.product;

import com.sidedish.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

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

	@MappedCollection(idColumn = "product_id")
	private final Set<Image> image;

}
