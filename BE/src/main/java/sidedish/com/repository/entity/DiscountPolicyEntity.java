package sidedish.com.repository.entity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("DISCOUNT_POLICY")
public class DiscountPolicyEntity {

	@Id
	private Long id;
	private String policyName;
	private float discountRate;

	public DiscountPolicyEntity(String policyName) {
		this.policyName = policyName;
	}

	public boolean isEqualsId(Long id) {
		return this.id == id;
	}
}
