package sidedish.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeliveryPolicy {

	private String deliveryInfo;
	private Long deliveryCharge;
	private Long freeDeliveryOverAmount;

}
