package kr.codesquad.sidedish.domain;

import java.util.Arrays;
import kr.codesquad.sidedish.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

	public static double SUPER_SALE_NUM = 2;
	public static double LAUNCHING_DISCOUNT = 0.8;
	public static double EVENT_DISCOUNT = 0.9;
	public static double SUPER_DISCOUNT = 0.7;

	private final Integer id;
	private final String name;
	private final String content;
	private final Integer price;
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

		String[] events = applyEvent.split(",");

		int discountPrice = convertDiscountPrice(events, price);

		String[] images;
		images = imgUrl.split(",");

		return new ProductDTO(id, name, content, price, discountPrice, quantity, dishType,
			sideDishType,
			events, images);
	}

	private int convertDiscountPrice(String[] events, int price) {
		if (events.length == SUPER_SALE_NUM) {
			// 30% 할인
			return (int) (price * SUPER_DISCOUNT);
		}
		if (applyEvent.contains("런칭특가")) {
			// 20% 할인
			return (int) (price * LAUNCHING_DISCOUNT);
		}
		if (applyEvent.contains("이벤트특가")) {
			// 10% 할인
			return (int) (price * EVENT_DISCOUNT);
		}
		return price;
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
