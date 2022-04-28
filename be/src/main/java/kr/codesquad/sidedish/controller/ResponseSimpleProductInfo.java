package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseSimpleProductInfo {

	private Integer id;
	private String name;
	private String content;
	private Integer price;
	private Integer discountPrice;
	private String applyEvent;
	private String imgUrl;

	public static ResponseSimpleProductInfo from(ProductDTO productDTO) {
		return new ResponseSimpleProductInfo(productDTO.getId(), productDTO.getName(),
			productDTO.getContent(), productDTO.getPrice(), productDTO.getDiscountPrice(),
			productDTO.getApplyEvent(), productDTO.getImgUrl()[0]);
	}
}
