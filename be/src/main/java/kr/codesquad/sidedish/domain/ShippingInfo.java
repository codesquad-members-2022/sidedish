package kr.codesquad.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Data
public class ShippingInfo {

	@Id
	private final Integer deliveryType;
	private final Integer deliveryCharge;
	private final String deliveryInfo;
}
