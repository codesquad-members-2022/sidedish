package sidedish.com.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DiscountPolicy {

	private String policyName;
	private float discountRate;
}
