package com.sidedish.domain.product;

import com.sidedish.domain.Image;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy = "product")
	private final List<Image> image = new ArrayList<>();


	public void addStock(int quantity){
		this.stock += quantity;
	}

	public void removeStock(int quantity){
		int restStock = this.stock - quantity;
		if (restStock < 0) {
			throw new IllegalStateException("재고가 부족합니다.");
		}
		this.stock = restStock;
	}
}
