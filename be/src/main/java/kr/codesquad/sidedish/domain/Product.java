package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.dto.ResponseProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

	private final Integer id;
	private final String name;
	private final String content;
	private final int price;
	private final Integer quantity;
	private final String dishType;
	private final String sideDishType;
	private final String applyEvent;
	private final String imgUrl;

	public static Product updateQuantity(Product product, Integer quantity) {
		return new Product(product.getId(), product.getName(), product.getContent(),
			product.getPrice(), quantity,
			product.getDishType(), product.getSideDishType(), product.getApplyEvent(),
			product.getImgUrl());
	}

	public ResponseProduct createResponseProduct() {
		return new ResponseProduct(id, name, content, price, quantity, dishType, sideDishType,
			applyEvent, imgUrl);
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
