package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.DeliveryType;
import kr.codesquad.sidedish.domain.ShippingInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShippingInfoDTO {

	private final Integer deliveryType;
	private final Integer deliveryCharge;
	private final String deliveryInfo;

	public static ShippingInfoDTO from(ShippingInfo shippingInfo) {

		DeliveryType deliveryType = DeliveryType.convertInfo(shippingInfo.getDeliveryInfo());

		return new ShippingInfoDTO(shippingInfo.getDeliveryType(), shippingInfo.getDeliveryCharge(),
			deliveryType.getValue());
	}
}
