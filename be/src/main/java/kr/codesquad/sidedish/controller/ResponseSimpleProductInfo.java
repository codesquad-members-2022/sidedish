package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseSimpleProductInfo {

	/**
	 * 음식이름 음식설명 가격 할인가격 이벤트 이미지URL 하나
	 */
	private Integer id;
	private String name;
	private String content;
	private Integer price;
	private Integer discountPrice;
	private String[] applyEvent;
	private String imgUrl;

	public static ResponseSimpleProductInfo from(ProductDTO productDTO) {
		return new ResponseSimpleProductInfo(productDTO.getId(), productDTO.getName(),
			productDTO.getContent(), productDTO.getPrice(), productDTO.getDiscountPrice(),
			productDTO.getApplyEvent(), productDTO.getImgUrl()[0]);
	}
}
