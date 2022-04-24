package kr.codesquad.sidedish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDTO {

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
}
