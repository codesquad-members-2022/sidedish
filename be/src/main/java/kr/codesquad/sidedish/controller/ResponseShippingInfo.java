package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.service.ShippingInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseShippingInfo {

	private final Integer deliveryCharge;
	private final String deliveryInfo;

	public static ResponseShippingInfo from(ShippingInfoDTO shippingInfoDTO) {

		return new ResponseShippingInfo(shippingInfoDTO.getDeliveryCharge(),
			shippingInfoDTO.getDeliveryInfo());
	}
}
