package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.service.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Data
public class Product {

	@Id
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

		int discountPrice = convertDiscountPrice(applyEvent, price);

		String[] images;
		images = imgUrl.split(",");

		return new ProductDTO(id, name, content, price, discountPrice, quantity, dishType,
			sideDishType,
			applyEvent, images);
	}

	private int convertDiscountPrice(String applyEvent, int price) {
		Discount discount = Discount.setSaleType(applyEvent);

		return (int) (price * discount.getValue());
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
