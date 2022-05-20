package com.sidedish.domain;

import com.sidedish.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Image {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	private String imagePath;
}
