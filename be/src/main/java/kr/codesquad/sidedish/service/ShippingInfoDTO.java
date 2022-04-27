package kr.codesquad.sidedish.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShippingInfoDTO {

	private final Integer deliveryType;
	private final Integer deliveryCharge;
	private final String deliveryInfo;
}
