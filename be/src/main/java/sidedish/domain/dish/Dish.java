package sidedish.domain.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import sidedish.domain.category.MainCategory;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

	@Id
	private Long id;
	private Long mainCategoryId;
	private String title;
	private String description;
	private int price;
	private int quantity;
	private double discountPolicy;
	private boolean morningDelivery;

}
