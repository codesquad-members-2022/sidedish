package sidedish.com.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class OrderEntity {

	@Id
	private Long id;
	private final Long productId;
	private final long totalPrice;
	private final long count;
	private final long deliveryPrice;

	@PersistenceConstructor
	public OrderEntity(Long productId, long totalPrice, long count,
		long deliveryPrice) {
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.count = count;
		this.deliveryPrice = deliveryPrice;
	}

	public Long getId() {
		return id;
	}
}
