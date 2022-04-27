package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDetailProductInfo {

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
	private ResponseShippingInfo shippingInfo;

	public static ResponseDetailProductInfo from(ProductDTO productDTO,
		ResponseShippingInfo shippingInfo) {
		return new ResponseDetailProductInfo(productDTO.getId(), productDTO.getName(),
			productDTO.getContent(), productDTO.getPrice(), productDTO.getDiscountPrice(),
			productDTO.getQuantity(),
			productDTO.getDishType(), productDTO.getSideDishType(), productDTO.getApplyEvent(),
			productDTO.getImgUrl(), shippingInfo);
	}
}
