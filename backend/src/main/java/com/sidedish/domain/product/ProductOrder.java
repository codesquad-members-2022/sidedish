package com.sidedish.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductOrder {
	private Long id;
	private Long productId;
	private Long userId;
	private int quantity;
}
