package kr.codesquad.sidedish.service;

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
}
