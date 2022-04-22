package sidedish.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DiscountPolicy {

	private String policyName;
	private float discountRate;

	public long calculateFixedPrice(long originalPrice) {
		return (long) (originalPrice * ((100 - discountRate) / 100));
	}
}
