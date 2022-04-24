package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

	public static double LAUNCHING_DISCOUNT = 0.8;
	public static double EVENT_DISCOUNT = 0.9;

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

	public ProductDTO createDTO() {

		int discountPrice = price;
		if (applyEvent.equals("런칭특가")) {
			// 20% 할인
			discountPrice = (int) (price * LAUNCHING_DISCOUNT);
		}
		if (applyEvent.equals("이벤트특가")) {
			// 10% 할인
			discountPrice = (int) (price * EVENT_DISCOUNT);
		}

		String[] imgArray;
		imgArray = imgUrl.split(",");

		return new ProductDTO(id, name, content, price, discountPrice, quantity, dishType,
			sideDishType,
			applyEvent, imgArray);
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
