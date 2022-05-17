package com.sidedish.domain.product;

import com.sidedish.domain.Image;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class Product {

	@Id @GeneratedValue
	@Column(name = "product_id")
	private Long id;

	private String productName;
	private String description;

	@Column(columnDefinition = "boolean default false")
	private boolean earlyDelivery;
	private int price;
	private int stock;

	@Enumerated(EnumType.STRING)
	private EventBadge eventBadge;

	@Enumerated(EnumType.STRING)
	private MainCategory mainCategory;
	@Enumerated(EnumType.STRING)
	private EventCategory eventCategory;

	private final List<Image> image = new ArrayList<>();

}
