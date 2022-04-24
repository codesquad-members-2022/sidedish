package kr.codesquad.sidedish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SimpleProductInfo {

	/**
	 * 음식이름 음식설명 가격 할인가격 이벤트 이미지URL 하나
	 */
	private Integer id;
	private String name;
	private String content;
	private int price;
	private int discountPrice;
	private String applyEvent;
	private String imgUrl;

	public static SimpleProductInfo from(ProductDTO productDTO) {
		return new SimpleProductInfo(productDTO.getId(), productDTO.getName(),
			productDTO.getContent(), productDTO.getPrice(), productDTO.getDiscountPrice(),
			productDTO.getApplyEvent(), productDTO.getImgUrl()[0]);
	}
}
