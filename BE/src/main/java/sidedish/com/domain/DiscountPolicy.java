package sidedish.com.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DiscountPolicy {

	private Long id;
	private String policyName;
	private long discountRate;

	public long calculateFixedPrice(long originalPrice) {
		return (long) (originalPrice * ((100 - discountRate) / (double) 100));
	}
}
