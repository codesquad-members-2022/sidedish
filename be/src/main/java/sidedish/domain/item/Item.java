package sidedish.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
	private double discountPolicy;
	private boolean morningDelivery;

}
