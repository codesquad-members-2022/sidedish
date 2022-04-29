package sidedish.com.repository.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("DISCOUNT_POLICY")
public class DiscountPolicyEntity {

	@Id
	private final Long id;
	private final String policyName;
	private final long discountRate;

	@PersistenceConstructor
	public DiscountPolicyEntity(Long id, String policyName, long discountRate) {
		this.id = id;
		this.policyName = policyName;
		this.discountRate = discountRate;
	}

	public boolean isEqualsId(Long id) {
		return this.id.equals(id);
	}
}
