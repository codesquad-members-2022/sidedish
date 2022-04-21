package sidedish.com.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("DISCOUNT_POLICY")
public class DiscountPolicy {

	@Id
	private Long id;
	private String policyName;
	private float discountRate;
	private LocalDateTime startAt;
	private LocalDateTime endAt;

	public DiscountPolicy(String policyName) {
		this.policyName = policyName;
	}
}
