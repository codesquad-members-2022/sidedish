package sidedish.com.repository.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@AllArgsConstructor

@Table("PRODUCT")
public class ProductEntity {

	@Id
	private Long id;
	private Long discountPolicyId;
	@MappedCollection(idColumn = "ID", keyColumn = "ID")
	private List<ImageEntity> imageEntities;
	private String productName;
	private String description;
	private long originalPrice;
	private String mealCategory;
	private String bestCategory;

}
