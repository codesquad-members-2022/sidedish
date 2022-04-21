package sidedish.com.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
@AllArgsConstructor

public class Product {

	@Id
	private Long id;
	private Long discountPolicyId;
	@MappedCollection(idColumn = "ID", keyColumn = "ID")
	private List<Image> image;
	private String productName;
	private String description;
	private long originalPrice;
	private String mealCategory;
	private String bestCategory;

}
