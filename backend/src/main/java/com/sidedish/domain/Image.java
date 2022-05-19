package com.sidedish.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sidedish.domain.product.Product;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Image {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	private String imagePath;
}
