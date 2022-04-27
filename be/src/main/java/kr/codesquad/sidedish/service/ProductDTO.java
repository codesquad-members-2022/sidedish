package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.DiscountType;
import kr.codesquad.sidedish.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDTO {

	private Integer id;
	private String name;
	private String content;
	private Integer price;
	private Integer discountPrice;
	private Integer quantity;
	private String dishType;
	private String sideDishType;
	private String applyEvent;
	private String[] imgUrl;
	private Integer deliveryType;

	public static ProductDTO from(Product product) {

		Integer discountPrice = convertDiscountPrice(product.getApplyEvent(), product.getPrice());

		String[] images;
		images = product.getImgUrl().split(",");

		return new ProductDTO(product.getId(), product.getName(), product.getContent(),
			product.getPrice(), discountPrice, product.getQuantity(), product.getDishType(),
			product.getSidedishType(), product.getApplyEvent(), images,
			product.getDeliveryType());
	}

	private static Integer convertDiscountPrice(String applyEvent, Integer price) {
		DiscountType discountType = DiscountType.convertSaleType(applyEvent);

		return (int) Math.round(price * discountType.getValue());
	}
}
