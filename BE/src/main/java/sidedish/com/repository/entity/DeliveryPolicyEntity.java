package sidedish.com.repository.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("DELIVERY_POLICY")
@Getter
public class DeliveryPolicyEntity {

	@Id
	private final Long id;
	private final String deliveryInfo;
	private final Long deliveryCharge;
	private final Long freeDeliveryOverAmount;

	@PersistenceConstructor
	public DeliveryPolicyEntity(Long id, String deliveryInfo, Long deliveryCharge,
		Long freeDeliveryOverAmount) {
		this.id = id;
		this.deliveryInfo = deliveryInfo;
		this.deliveryCharge = deliveryCharge;
		this.freeDeliveryOverAmount = freeDeliveryOverAmount;
	}

	public boolean isEqualsId(Long id) {
		return this.id.equals(id);
	}
}
