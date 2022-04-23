package sidedish.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import sidedish.domain.images.Images;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Item {

	@Id
	private Long id;
	private Long mainCategoryId;
	private String title;
	private String description;
	private int price;
	private int quantity;
	private String discountPolicy;
	private boolean morningDelivery;
	@MappedCollection(idColumn = "item_id", keyColumn = "id")
	private List<Images> images;
}
