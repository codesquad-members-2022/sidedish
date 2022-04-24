package kr.codesquad.sidedish.dto;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DetailProductInfo {

	private Integer id;
	private String name;
	private String content;
	private int price;
	private int discountPrice;
	private Integer quantity;
	private String dishType;
	private String sideDishType;
	private String applyEvent;
	private String[] imgUrl;

	public static DetailProductInfo from(ProductDTO productDTO) {
		return new DetailProductInfo(productDTO.getId(), productDTO.getName(),
			productDTO.getContent(), productDTO.getPrice(), productDTO.getDiscountPrice(),
			productDTO.getQuantity(),
			productDTO.getDishType(), productDTO.getSideDishType(), productDTO.getApplyEvent(),
			productDTO.getImgUrl());
	}
}
