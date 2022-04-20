package sidedish.com.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class DisCountPolicy {

	private Long id;
	private String policyName;
	private float discountRate;
	private LocalDateTime startAt;
	private LocalDateTime endAt;

	public DisCountPolicy(String policyName) {
		this.policyName = policyName;
	}
}
