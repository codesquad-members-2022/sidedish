package sidedish.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeliveryPolicy {

	private Long id;
	private String deliveryInfo;
	private Long deliveryCharge;
	private Long freeDeliveryOverAmount;

}
