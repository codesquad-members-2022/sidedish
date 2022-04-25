package sidedish.com.repository.entity;

import java.util.List;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("PRODUCT")
public class ProductEntity {

	@Id
	private final Long id;
	private final Long discountPolicyId;
	private final Long deliveryPolicyId;
	@MappedCollection(idColumn = "PRODUCT_ID", keyColumn = "ID")
	private final List<ImageEntity> imageEntities;
	private final String productName;
	private final String description;
	private final long originalPrice;
	private final String mealCategory;
	private final String bestCategory;


	@PersistenceConstructor
	public ProductEntity(Long id, Long discountPolicyId,
		Long deliveryPolicyId, List<ImageEntity> imageEntities, String productName,
		String description, long originalPrice,
		String mealCategory, String bestCategory) {
		this.id = id;
		this.discountPolicyId = discountPolicyId;
		this.deliveryPolicyId = deliveryPolicyId;
		this.imageEntities = imageEntities;
		this.productName = productName;
		this.description = description;
		this.originalPrice = originalPrice;
		this.mealCategory = mealCategory;
		this.bestCategory = bestCategory;
	}
}
